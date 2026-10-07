class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check whether current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If valid strings are already found,
            // don't remove more parentheses
            if (found) {
                continue;
            }

            // Generate next level
            for (int i = 0; i < current.length(); i++) {

                // Only remove parentheses
                if (current.charAt(i) != '(' &&
                    current.charAt(i) != ')') {
                    continue;
                }

                String next =
                    current.substring(0, i) +
                    current.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}