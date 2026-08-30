class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        if(n == 0 || n == 1){
            return n;
        }
        int index1 = -1, index2 = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] > max){
                max = nums[i];
                index1 = i;
            }

            if(nums[i] < min){
                min = nums[i];
                index2 = i; 
            }
        }

        int total = 0;
        
        int indexSmall = Math.min(index1, index2);
        int indexLarge = Math.max(index1, index2);

        int val = (indexSmall + 1) + (n - indexLarge);
        

        int ans = Math.min(indexLarge+1, Math.min(n - indexSmall , val));

        
        
        return ans;
    }
}