public class ROP {
    public static void main(String[] args) {
        String input = "(()(()))((())())(()(()(())))()()((()))";
        removeOuterParentheses(input); 
    }

    public static void removeOuterParentheses(String input) {
        // Track depth to skip outermost parentheses of each primitive group
        int depth = 0;
        StringBuilder sol = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '(') {
                if (depth > 0)
                    sol.append(c);
                depth++;
            } else if (c == ')') {
                depth--;
                if (depth > 0)
                    sol.append(c);
            }
        }
        System.out.println(sol);
    }
}
