class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n = nums.length;

        if(n <= 2) return n;

        int bits = countBit(n);
        return 1 << bits;
    }

    public int countBit(int num){

        int index = -1;
        for(int i = 31 ; i >= 0 ; i--){
            if(checkBit(num, i)){
                index = i;
                break;
            }
        }

        return index + 1;
    }

    public boolean checkBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
}