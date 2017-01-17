package core;

/**
 * The algorithm is based upon a single idea. Expressions are represented as a
 * tree of smaller expressions. Each expression consists of either:
 * {@code AbstractFunction}, {@code AbstractOperator}, {@code Constant},
 * {@code Variable}. Each of those elements inheriting should implement the
 * following methods.
 * 
 * 
 * @author luka
 * 
 */
public abstract class IDerivable {

	/**
	 * Evaluate this expression to find it's value
	 * 
	 * @return value - the value of this expression
	 * @throws NumberFormatException
	 *             - this exception shall be thrown if the expression cannot be
	 *             evaluated e.g. variables haven't been replaced with a
	 *             constant.
	 */
	public abstract double evaluate() throws NumberFormatException;

	/**
	 * Get a new object created by deriving this one with respect to a given
	 * variable.
	 * 
	 * @param by
	 *            The variable to derive by.
	 * @return newObject - A new object such that
	 *         (this).derive(by).equals(newObject)
	 */
	public IDerivable getDerivative(Variable by) {
		return getDerivative(by.getName());
	}

	/**
	 * Get a new object created by deriving this one with respect to a given
	 * variable.
	 * 
	 * @param by
	 *            The variable to derive by.
	 * @return newObject - A new object such that
	 *         (this).derive(by).equals(newObject)
	 */

	public abstract IDerivable getDerivative(String by);

	/**
	 * Get a new object created by simplifying this one.
	 * 
	 * @return newObject - A new object such that
	 *         (this).simplify().equals(newObject)
	 */
	public abstract IDerivable getSimplified();

}
