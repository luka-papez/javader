package operators;

import constants.Constants;
import core.AbstractOperator;
import core.Constant;
import core.IDerivable;

public class Power extends AbstractOperator {

	private double exponent;

	public Power(IDerivable left, double right) {
		this(left, new Constant(right));
	}

	public Power(IDerivable left, Constant right) {
		super(left, right);
		this.exponent = right.getValue();
	}

	@Override
	public IDerivable getDerivative(String by) {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "(" + left.toString() + ")^" + right.toString();
	}

	@Override
	public IDerivable getSimplified() {
		IDerivable lsimple = left.getSimplified();

		if (lsimple.equals(Constants.ZERO)) {
			return new Constant(0);

		} else {
			if (right.equals(Constants.ZERO)) {
				return new Constant(1);
			} else {
				return new Power(lsimple, exponent);
			}
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.pow(left.evaluate(), exponent);
	}
}
