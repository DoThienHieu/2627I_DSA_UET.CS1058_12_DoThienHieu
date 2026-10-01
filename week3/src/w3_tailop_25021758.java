import java.util.Scanner;
import java.util.Stack;

public class w3_tailop_25021758 {
    static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }
    static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(' ');
            }
            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {

                while (!stack.isEmpty()
                        && stack.peek() != '('
                        && priority(stack.peek()) >= priority(c)) {

                    result.append(stack.pop()).append(' ');
                }

                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String postfix = infixToPostfix(expression);
        System.out.println(postfix);
        scanner.close();
    }
}