package functions;

import core.AbstractFunction;
import core.Constant;
import core.IDerivable;

public class Signum extends AbstractFunction {

	public Signum(IDerivable argument) {
		super(argument);
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return Math.signum(argument.evaluate());
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Constant(0);
	}

	@Override
	public IDerivable getSimplified() {
		return new Signum(argument.getSimplified());
	}

}
