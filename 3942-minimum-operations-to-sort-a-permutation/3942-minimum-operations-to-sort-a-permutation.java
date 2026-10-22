
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        boolean normal = true;
        boolean reversed = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n) {
                normal = false;
            }

            if (nums[n - 1 - i] != (nums[n - 1] + i) % n) {
                reversed = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (normal) {
            ans = Math.min(zeroIndex, n - zeroIndex + 2);
        }

        if (reversed) {
            int k = n - 1 - zeroIndex;
            ans = Math.min(ans, Math.min(k, n - k) + 1);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
