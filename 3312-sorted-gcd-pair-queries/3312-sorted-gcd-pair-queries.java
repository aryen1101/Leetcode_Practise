import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : nums) {
            freq[x]++;
        }

        int[] divisible = new int[max + 1];

        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                divisible[d] += freq[multiple];
            }
        }

        long[] gcdCount = new long[max + 1];

        for (int d = 1; d <= max; d++) {
            long count = divisible[d];
            gcdCount[d] = count * (count - 1) / 2;
        }

        for (int d = max; d >= 1; d--) {
            for (int multiple = d * 2; multiple <= max; multiple += d) {
                gcdCount[d] -= gcdCount[multiple];
            }
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long q = queries[i];

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] > q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}