class Solution {
    public int maximumProduct(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);

        int val1 = nums[0] * nums[1] * nums[n-1];
        int val2 = nums[n-1] * nums[n-2] * nums[n-3];

        return Math.max(val1, val2);
    }
}