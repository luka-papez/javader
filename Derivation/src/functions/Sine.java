package functions;

import operators.Multiplication;
import constants.Constants;
import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Sine extends AbstractFunction {

	public Sine(IDerivable argument) {
		super(argument);
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.sin(argument.evaluate());
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Multiplication(new Cosine(argument),
				argument.getDerivative(by));
	}

	@Override
	public IDerivable getSimplified() {
		if (argument.getSimplified().equals(Constants.ZERO)) {
			return new Constant(0);
		} else {
			return this;
		}
	}

	public String toString() {
		return "sin(" + argument.toString() + ")";
	}

}
