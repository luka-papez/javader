package conversion;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import operators.Addition;
import operators.Division;
import operators.Multiplication;
import operators.Power;
import operators.Subtraction;
import core.Constant;
import core.IDerivable;
import core.Variable;
import functions.Cosine;
import functions.Exp;
import functions.Logn;
import functions.Sine;

/**
 * Factory method used for creating new functions.
 * 
 * @author luka
 * 
 */
public class FunctionFactory {
	public static IDerivable fromInfix(String infixExpression,
			String... variables) {
		List<Token> tokens = InfixToRPN.convert(infixExpression,
				Arrays.asList(variables));
		return fromPostfix(tokens);
	}

	public static IDerivable fromPostfix(String postfixExpression,
			String... variables) {
		return fromPostfix(InfixToRPN.tokenize(postfixExpression,
				Arrays.asList(variables)));
	}

	public static IDerivable fromInfix(String infixExpression,
			List<String> variables) {
		List<Token> tokens = InfixToRPN.convert(infixExpression, variables);
		return fromPostfix(tokens);
	}

	public static IDerivable fromPostfix(String postfixExpression,
			List<String> variables) {
		return fromPostfix(InfixToRPN.tokenize(postfixExpression, variables));
	}

	private static IDerivable fromPostfix(List<Token> postfixExpression) {
		Stack<IDerivable> stack = new Stack<>();
		try {
			for (Token token : postfixExpression) {
				if (token.type.equals("variable")) {
					stack.push(new Variable(token.token));
				} else if (token.type.equals("number")) {
					stack.push(new Constant(Double.parseDouble(token.token)));
				} else if (token.type.equals("function")) {
					IDerivable argument = stack.pop();
					if (token.token.equals("sin")) {
						stack.push(new Sine(argument));
					} else if (token.token.equals("cos")) {
						stack.push(new Cosine(argument));
					} else if (token.token.equals("exp")) {
						stack.push(new Exp(argument));
					} else if (token.token.equals("ln")) {
						stack.push(new Logn(argument));
					} else {
						throw new Exception();
					}
				} else if (token.type.equals("operator")) {
					IDerivable right = stack.pop();
					IDerivable left = stack.pop();
					if (token.token.equals("+")) {
						stack.push(new Addition(left, right));
					} else if (token.token.equals("-")) {
						stack.push(new Subtraction(left, right));
					} else if (token.token.equals("*")) {
						stack.push(new Multiplication(left, right));
					} else if (token.token.equals("/")) {
						stack.push(new Division(left, right));
					} else if (token.token.equals("^")) {
						try {
							Constant c = (Constant) right;
							stack.push(new Power(left, c));
						} catch (Exception e) {
							System.err
									.println("Powering is only possible with constant.");
							throw new Exception();
						}
					} else {
						throw new Exception();
					}
				} else {
					System.err.println("Conversion error.");
				}
			}
		} catch (Exception e) {
			System.err.println("Conversion error.");
		}

		return stack.pop();
	}
}
