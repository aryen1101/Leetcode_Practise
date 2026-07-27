class Solution {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int max = 0;
        int secMax = 0;

        for(int num : nums){

            if(num >= max){
                secMax = max;
                max = num;
            }

            else if(num < max && num >= secMax){
                secMax = num;
            }
        }

        return (max-1) * (secMax-1);
        
    }
}