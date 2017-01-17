package functions;

import operators.Multiplication;
import constants.Constants;
import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Cosine extends AbstractFunction {

	public Cosine(IDerivable argument) {
		super(argument);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Multiplication(new Negation(new Sine(argument)), argument
				.getDerivative(by).getSimplified());
	}


	public String toString() {
		return "cos(" + argument.toString() + ")";
	}

	@Override
	public IDerivable getSimplified() {
		if (argument.getSimplified().equals(Constants.PIHALF)) {
			return new Constant(0);
		} else {
			return this;
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.cos(argument.evaluate());
	}

}
