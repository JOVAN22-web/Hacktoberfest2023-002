import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        String openingBrackets = "({[";
        String closingBrackets = ")}]";

        for (char c : s.toCharArray()) {
            if (openingBrackets.contains(String.valueOf(c))) {
                stack.push(c);
            } else if (closingBrackets.contains(String.valueOf(c))) {
                if (stack.isEmpty()) {
                    return false;  // Unmatched closing bracket
                }

                char top = stack.pop();
                if (openingBrackets.indexOf(top) != closingBrackets.indexOf(c)) {
                    return false;  // Mismatched opening and closing brackets
                }
            }
        }

        return stack.isEmpty();  // If the stack is empty, the string is balanced
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            if (isBalanced(inputString)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}
