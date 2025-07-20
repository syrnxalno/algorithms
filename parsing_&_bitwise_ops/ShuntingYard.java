import java.util.*;

public class ShuntingYard {

    private static int getPrecedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    public static List<String> toPostfix(String[] tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && isOperator(operators.peek()) &&
                       getPrecedence(token) <= getPrecedence(operators.peek())) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    public static int evaluatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "3 + 4 * 2 / ( 1 - 5 )";
        String[] tokens = expression.split(" ");
        List<String> postfix = toPostfix(tokens);
        System.out.println("Postfix: " + String.join(" ", postfix));
        System.out.println("Result: " + evaluatePostfix(postfix));
    }
}
