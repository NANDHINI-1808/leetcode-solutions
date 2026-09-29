class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        long totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        long target = totalSum - x;

        // Target cannot be negative
        if (target < 0) {
            return -1;
        }

        // If target is 0, remove everything
        if (target == 0) {
            return n;
        }

        int left = 0;
        long sum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // Reduce window if sum becomes too large
            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            // Found a subarray with target sum
            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}