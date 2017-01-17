package core;

/**
 * 
 * A specification of {@code IDerivable} models a mathematical operator such as
 * +, -, *, ^...
 * 
 * @author luka
 * 
 */
public abstract class AbstractOperator extends IDerivable {
	// left and right operands
	protected IDerivable left, right;

	/**
	 * Create a new mathematical operator with left and right arguments.
	 * 
	 * @param left
	 * @param right
	 */
	public AbstractOperator(IDerivable left, IDerivable right) {
		this.left = left;
		this.right = right;
	}

}
