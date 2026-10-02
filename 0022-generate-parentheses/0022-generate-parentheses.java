import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generate("", 0, 0, n, result);

        return result;
    }

    private void generate(String current, int open, int close, int n,
                          List<String> result) {

        // If we used all parentheses
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // We can add '(' if open < n
        if (open < n) {
            generate(current + "(", open + 1, close, n, result);
        }

        // We can add ')' only if close < open
        if (close < open) {
            generate(current + ")", open, close + 1, n, result);
        }
    }
}