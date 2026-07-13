import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Create a HashMap to store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Find the required number
            int need = target - nums[i];

            // Check if the required number is already in the map
            if (map.containsKey(need)) {
                return new int[] { map.get(need), i };
            }

            // Store current number and its index
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
