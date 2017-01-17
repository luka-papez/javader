package operators;

import constants.Constants;
import core.AbstractOperator;
import core.Constant;
import core.IDerivable;
import functions.Negation;

public class Subtraction extends AbstractOperator {

	public Subtraction(IDerivable left, IDerivable right) {
		super(left, right);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Subtraction(left.getDerivative(by), right.getDerivative(by));
	}

	public String toString() {
		return left.toString() + " - " + right.toString();
	}

	@Override
	public IDerivable getSimplified() {
		IDerivable lsimple = left.getSimplified();
		IDerivable rsimple = right.getSimplified();

		if (lsimple.equals(Constants.ZERO)) {
			if (rsimple.equals(Constants.ZERO)) {
				return new Constant(0);
			} else {
				return new Negation(rsimple);
			}
		} else {
			if (rsimple.equals(Constants.ZERO)) {
				return lsimple;
			} else {
				return new Subtraction(lsimple, rsimple);
			}
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return left.evaluate() - right.evaluate();
	}
}
