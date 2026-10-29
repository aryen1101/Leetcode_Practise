class Solution {
    public int majorityElement(int[] nums) {
        
        int val = 0;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                val = num;
            }

            if(val == num){
                count++;
            }
            else{
                count--;
            }
        }

        return val;
    }
}