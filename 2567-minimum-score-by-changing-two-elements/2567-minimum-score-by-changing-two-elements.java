class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;

        Arrays.sort(nums);

        int val1 = nums[n-1] - nums[2];
        int val2 = nums[n-3] - nums[0];
        int val3 = nums[n-2] - nums[1];

        return Math.min(val1, Math.min(val2, val3));
    }
}