class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> map = new HashMap<>();

        // Step 1: Store knowledge in HashMap
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        // Step 2: Traverse the string
        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {

                // Move after '('
                i++;

                StringBuilder key = new StringBuilder();

                // Collect key until ')'
                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                // Get value from HashMap
                String value = map.getOrDefault(key.toString(), "?");

                // Add value to answer
                ans.append(value);

                // Skip ')'
                i++;

            } else {

                // Normal character
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}