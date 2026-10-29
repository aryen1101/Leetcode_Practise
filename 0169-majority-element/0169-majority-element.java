class Solution {
    public int majorityElement(int[] nums) {

        int ans = 0;
        int n = nums.length;

        for(int i = 0 ; i < 32 ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                if(checkBit(nums[j], i)){
                    count++;
                }
                
            }
            if(count > n/2){
                ans = setBit(ans , i);
            }
        }

        return ans;
        
    }

    public boolean checkBit(int n, int i) {
        return ((n >> i) & 1) > 0;
    }

    public int setBit(int n, int i) {
        return n | (1 << i);
    }
}