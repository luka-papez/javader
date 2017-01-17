package operators;

import constants.Constants;
import core.AbstractOperator;
import core.Constant;
import core.IDerivable;
import functions.Negation;

public class Multiplication extends AbstractOperator {

	public Multiplication(IDerivable left, IDerivable right) {
		super(left, right);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Addition(new Multiplication(left.getDerivative(by), right),
				new Multiplication(left, right.getDerivative(by)));
	}

	public String toString() {
		StringBuilder retVal = new StringBuilder();
		if (left instanceof Addition || left instanceof Subtraction
				|| left instanceof Negation) {
			retVal.append("(" + left.toString() + ") * ");
		} else {
			retVal.append(left.toString() + " * ");
		}

		if (right instanceof Addition || right instanceof Subtraction
				|| right instanceof Negation) {
			retVal.append("(" + right.toString() + ")");
		} else {
			retVal.append(right.toString());
		}
		return retVal.toString();
	}

	@Override
	public IDerivable getSimplified() {
		IDerivable lsimple = left.getSimplified();
		IDerivable rsimple = right.getSimplified();

		if (lsimple.equals(Constants.ZERO) || rsimple.equals(Constants.ZERO)) {
			return new Constant(0);
		}
		if (lsimple.equals(Constants.ONE)) {
			if (rsimple.equals(Constants.ONE)) {
				return new Constant(1);
			} else {
				return rsimple;
			}
		} else if (rsimple.equals(Constants.ONE)) {
			return lsimple;

		} else {
			return new Multiplication(lsimple, rsimple);
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return left.evaluate() * right.evaluate();
	}

}
