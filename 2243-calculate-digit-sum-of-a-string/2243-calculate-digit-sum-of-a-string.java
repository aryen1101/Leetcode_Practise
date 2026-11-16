
class Solution {
    public String digitSum(String s, int k) {
        return solve(s, k);
    }

    public String solve(String s, int k) {
        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int index = 0;

        for (char ch : s.toCharArray()) {
            sum += ch - '0';
            index++;

            if (index == k) {
                sb.append(sum);
                sum = 0;
                index = 0;
            }
        }

        if (index > 0) {
            sb.append(sum);
        }

        return solve(sb.toString(), k);
    }
}
