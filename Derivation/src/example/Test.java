package example;

import conversion.FunctionFactory;
import core.IDerivable;

public class Test {
	public static void main(String[] args) {
		IDerivable function = FunctionFactory.fromInfix(
				"5*cos(x) + 6*exp(5*y)", "x", "y");
		System.out.println(function.getSimplified().toString());

		IDerivable derivation = function.getDerivative("x");
		System.out.println(derivation.getSimplified().toString());

		IDerivable function2 = FunctionFactory.fromInfix(
				"ln(2*cos(5*x)) + sin(3*exp(4*cos(2*x)))", "x", "y");
		System.out.println(function2.getSimplified().toString());

		IDerivable derivation2 = function2.getDerivative("x");
		System.out.println(derivation2.getSimplified().toString());

	}
}
