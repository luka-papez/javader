package functions;

import operators.Division;
import operators.Multiplication;
import constants.Constants;
import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Logn extends AbstractFunction {

	public Logn(IDerivable argument) {
		super(argument);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Multiplication(new Division(new Constant(1), argument),
				argument.getDerivative(by).getSimplified());
	}

	@Override
	public IDerivable getSimplified() {
		if (argument.equals(Constants.ONE)) {
			return new Constant(0);
		} else {
			return this;
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.log(argument.evaluate());
	}

	public String toString() {
		return "ln(" + argument.toString() + ")";
	}

}
