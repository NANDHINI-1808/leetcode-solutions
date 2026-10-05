class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(score);
                score = 0;
            } 
            else {
                int previous = stack.pop();

                if (score == 0) {
                    score = 1;
                } else {
                    score = 2 * score;
                }

                score = previous + score;
            }
        }

        return score;
    }
}