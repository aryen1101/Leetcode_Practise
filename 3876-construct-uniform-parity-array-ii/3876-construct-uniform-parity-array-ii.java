class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int evenCount = 0, oddCount = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums1){

            if(num % 2 == 0) evenCount++;
            else{
                oddCount++;
            }

            if(num < min){
                min = num;
            }
        }

        if(evenCount == 0 || oddCount == 0){
            return true;
        }

        if(min % 2 == 1){
            return true;
        }

        return false;
    }
}