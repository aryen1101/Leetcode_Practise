class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();
        int count_1 = 0, count_01 = 0, count_02 = 0;
        int max = 0;

        int index = 0;
        while(index < n){
            char ch = s.charAt(index);

            if(ch == '0'){
                count_01++;
                index++;
            }

            else{

                while(index < n && s.charAt(index) == '1'){
                    index++;
                    count_1++;
                }

                while(index < n && s.charAt(index) == '0'){
                    index++;
                    count_02++;
                }

                if(count_01 != 0 && count_02 != 0){
                max = Math.max(max, count_01 + count_02);
                }
                count_01 = count_02;
                count_02 = 0;
            }
        }

        return max + count_1;
        
    }
}