package core;

/**
 * A specification of {@code IDerivable} models a constant expression.
 * 
 * @author luka
 * 
 */

public class Constant extends IDerivable {

	protected double value;

	public Constant(double value) {
		this.value = value;
	}

	@Override
	public double evaluate() throws NumberFormatException {
		return value;
	}

	@Override
	public IDerivable getDerivative(String by) {
		return new Constant(0);
	}

	@Override
	public IDerivable getSimplified() {
		return new Constant(value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String toString() {
		return Double.toString(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constant other = (Constant) obj;
		if (Double.doubleToLongBits(value) != Double
				.doubleToLongBits(other.value))
			return false;
		return true;
	}

}
