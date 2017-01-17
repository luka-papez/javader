package conversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToRPN {

    // Shunting-yard algorithm
    public static List<Token> convert(String infixExpression, List<String> variables) {
        List<Token> input = tokenize(infixExpression, variables);
        List<Token> output = new ArrayList<>();
        Stack<Token> stack = new Stack<>();
        String pred = "-+*/";

        for (Token token : input) {
            if (token.type.equals("number") || token.type.equals("variable")) {
                output.add(token);
            } else if (token.type.equals("function")) {
                stack.push(token);
            } else if (token.type.equals("separator")) {
                // not supported
            } else if (token.type.equals("operator")) {
                while (!stack.isEmpty()) {
                    if (stack.peek().type.equals("operator")) {
                        char operator2 = stack.peek().token.charAt(0);

                        if (!stack.peek().token.equals("^")) {
                            if (pred.indexOf(token.token.charAt(0)) <= pred.indexOf(operator2)) {
                                output.add(stack.pop());
                            } else {
                                break;
                            }
                        }
                    } else {
                        break;
                    }

                }
                stack.push(token);
            } else if (token.type.equals("left")) {
                stack.push(token);
            } else if (token.type.equals("right")) {
                try {
                    while (!stack.peek().type.equals("left")) {
                        output.add(stack.pop());
                    }
                    stack.pop();
                    if (!stack.isEmpty()) {
                        if (stack.peek().type.equals("function")) {
                            output.add(stack.pop());
                        }
                    }

                } catch (Exception e) {
                    throw new IllegalArgumentException("Mismatched parentheses.");
                }
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.peek().type.equals("operator")) {
                throw new IllegalArgumentException("Mismatched parentheses.");
            } else {
                output.add(stack.pop());
            }
        }

        return output;
    }

    public static List<Token> tokenize(String expression, List<String> variables) {
        Tokenizer tokenizer = new Tokenizer(variables);
        tokenizer.tokenize(expression);
        return tokenizer.getTokens();
    }

    // Unit testing
    public static void main(String[] args) {
        String[] vars = { "x", "y", "z" };
        List<String> variables = Arrays.asList(vars);
        System.out.println(InfixToRPN.convert("1*2*3/4*5*6", variables));

    }
}
