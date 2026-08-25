class Solution {
    public int missingMultiple(int[] nums, int k) {

        int i = k;
        while(true){
            boolean isPresent = false;

            for(int num : nums){
                if(num == i){
                    isPresent = true;
                    break;
                }
            }

            if(!isPresent) return i;
            i += k;

        }
    }
}