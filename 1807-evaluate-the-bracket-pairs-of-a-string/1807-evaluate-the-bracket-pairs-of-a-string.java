class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int start = -1, end = s.length();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                start = i;
            } else if (s.charAt(i) == ')') {
                end = i;
            }

            else if (start == -1 && end == s.length()) {
                sb.append(s.charAt(i));
            }

            if(start != -1 && end != s.length()){
                if (map.containsKey(s.substring(start+1, end))) {
                    sb.append(map.get(s.substring(start+1, end)));
                } else {
                    sb.append('?');
                }
            }

            if(end != s.length()) {
                start = -1;
                end = s.length();
            }
        }
        return sb.toString();

    }
}