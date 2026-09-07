class Solution {
    public int distinctSubseqII(String s) {
        
        int n = s.length();
        int mod = 1000000007;

        long[] dp = new long[n+1];
        dp[0] = 1;

        int[] prev = new int[26];

        Arrays.fill(prev , -1);
        
        for(int i = 1 ; i <= n ; i++){

            char ch = s.charAt(i-1);
            dp[i] = ((2 * dp[i-1]));
            if(prev[ch-'a'] != -1){
                dp[i] -= dp[prev[ch-'a']];
            }

            dp[i] = (dp[i] + mod) % mod;
            prev[ch - 'a'] = i - 1;
        }

        return (int)(dp[n] - 1 + mod) % mod;
    }
}