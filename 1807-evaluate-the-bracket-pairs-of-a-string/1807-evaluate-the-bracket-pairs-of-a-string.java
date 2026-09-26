class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        int n = s.length();
        HashMap<String , String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }

        int start = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){

            if(s.charAt(i) == '('){
                start = i;
            }

            else if(s.charAt(i) == ')'){

                String ss = s.substring(start+1, i);
                if(map.containsKey(ss)){
                    sb.append(map.get(ss));
                }
                else{
                    sb.append('?');
                }
                start = -1;
            }
            else if(start == -1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}