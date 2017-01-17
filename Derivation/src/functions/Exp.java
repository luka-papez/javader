package functions;

import operators.Multiplication;
import constants.Constants;
import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Exp extends AbstractFunction {

	public Exp(IDerivable argument) {
		super(argument);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Multiplication(this, argument.getDerivative(by));
	}

	@Override
	public IDerivable getSimplified() {
		if (argument.getSimplified().equals(Constants.ZERO)) {
			return new Constant(1);
		} else {
			return this;
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.exp(argument.evaluate());
	}

	public String toString() {
		return "exp(" + argument.toString() + ")";
	}
}
