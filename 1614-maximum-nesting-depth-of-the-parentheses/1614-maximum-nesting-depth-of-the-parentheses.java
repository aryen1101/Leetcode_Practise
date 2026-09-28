class Solution {
    public int maxDepth(String s) {
        
        int depth = 0;
        int n = s.length();
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            
            char ch = s.charAt(i);
            if(ch == '('){
                max++;
                depth = Math.max(depth, max);
            }
            else if(ch == ')'){
                max--;
            }
        }
        return depth;
    }
}