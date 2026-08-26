class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
               
        int n = s.length();
        String string = "";

        for (int i = 0; i < n; i++) {

            int count1 = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < n; j++) {

                sb.append(s.charAt(j));

                if (s.charAt(j) == '1')
                    count1++;

                if (count1 > k)
                    break;

                if (count1 == k) {
                    String curr = sb.toString();

                    if (string.isEmpty() ||
                        curr.length() < string.length() ||
                        (curr.length() == string.length() && curr.compareTo(string) < 0)) {

                        string = curr;
                    }
                }
            }
        }

        return string;
    }
}