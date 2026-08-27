class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {

     
            int[] count = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {

                int index = target.charAt(j) - 'a';

                if (count[index] == 0) {
                    possible = false;
                    break;
                }

                count[index]--;
            }

            if (!possible)
                continue;

            int current = target.charAt(i) - 'a';

            for (int c = current + 1; c < 26; c++) {

                if (count[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(target.substring(0, i));

                    ans.append((char) ('a' + c));

                    count[c]--;

                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}