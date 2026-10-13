class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long total = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                nums[i] = nums[i] * -1;
            }
        }

        Arrays.sort(nums);

        int i = 0, j = n - 1;
        while(i < j){
            total += (long) nums[j] * nums[j];
            total -= (long) nums[i] * nums[i];
            i++;
            j--;
        }

        if(n % 2 == 1) {
            total += (long) nums[i] * nums[i];
        }

        return total;
    }
}