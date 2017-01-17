package core;

/**
 * A specification of {@code IDerivable}, models a mathematical function of
 * single arity.
 * 
 * @author luka
 */
public abstract class AbstractFunction extends IDerivable {
	// argument of the function
	protected IDerivable argument;

	/**
	 * Construct a new AbstractFunction from given argument such that this =
	 * f(argument)
	 * 
	 * @param argument
	 *            - argument of the function
	 */
	public AbstractFunction(IDerivable argument) {
		this.argument = argument;
	}

}
