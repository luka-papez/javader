package operators;

import constants.Constants;
import core.AbstractOperator;
import core.Constant;
import core.IDerivable;
import functions.Negation;

/**
 * Protected division. Returns 1 when divider is 0.
 * 
 * @author luka
 * 
 */
public class Division extends AbstractOperator {

	public Division(IDerivable left, IDerivable right) {
		super(left, right);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Division(new Subtraction(new Multiplication(
				left.getDerivative(by), right), new Multiplication(left,
				right.getDerivative(by))), new Power(left, 2));
	}

	public String toString() {
		StringBuilder retVal = new StringBuilder();
		if (left instanceof Addition || left instanceof Subtraction
				|| left instanceof Negation) {
			retVal.append("(" + left.toString() + ") / ");
		} else {
			retVal.append(left.toString() + " / ");
		}

		if (right instanceof Addition || right instanceof Subtraction
				|| right instanceof Negation || right instanceof Multiplication) {
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

		if (rsimple.equals(Constants.ZERO)) {
			return new Constant(1);
		}

		if (lsimple.equals(Constants.ZERO)) {
			return new Constant(0);
		}

		if (lsimple.equals(Constants.ONE)) {
			if (rsimple.equals(Constants.ONE)) {
				return new Constant(1);
			} else {
				return new Division(new Constant(1), rsimple);
			}
		} else if (rsimple.equals(Constants.ONE)) {
			return lsimple;

		} else {
			return new Division(lsimple, rsimple);
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		if (right.evaluate() == 0) {
			return 1;
		}

		return left.evaluate() / right.evaluate();
	}

}
