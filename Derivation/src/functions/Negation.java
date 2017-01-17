package functions;

import constants.Constants;
import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Negation extends AbstractFunction {

	public Negation(IDerivable argument) {
		super(argument);
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Negation(argument.getDerivative(by));
	}

	@Override
	public IDerivable getSimplified() {
		if (argument.getSimplified().equals(Constants.ZERO)) {
			return new Constant(0);
		} else {
			return this;
		}
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return -argument.evaluate();
	}

	public String toString() {
		return "-" + argument.toString();
	}
}
