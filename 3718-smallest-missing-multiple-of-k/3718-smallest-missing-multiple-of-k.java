class Solution {
    public int missingMultiple(int[] nums, int k) {

        for(int i = k ;  ; i+=k){
            boolean isPresent = false;

            for(int num : nums){
                if(num == i){
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent) return i;

        }
    }
}