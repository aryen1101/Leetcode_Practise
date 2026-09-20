class Solution {
    public int reverseDegree(String s) {
        
        int total = 0;
        int count = 1;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            int val = 'z' - ch + 1;
            val *= i+1;
            total += val;
        }
        return total;
    }
}