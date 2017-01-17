package core;

public class Variable extends IDerivable {

	private String name;

	private boolean isDerived = false, isNullified = false;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public double evaluate() throws NumberFormatException {
		throw new NumberFormatException(
				"In order to evaluate expression you must first substitute variable:"
						+ name + " with a constant.");
	}

	@Override
	public IDerivable getDerivative(String by) {
		if (!isDerived && name.equals(by)) {
			return new Constant(1);
		} else {
			return new Constant(0);
		}
	}

	@Override
	public IDerivable getSimplified() {
		if (isDerived) {
			if (isNullified) {
				return new Constant(0);
			} else {
				return new Constant(1);
			}
		}

		return new Variable(name);
	}

	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Variable other = (Variable) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
