class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int[] xorPair = new int[2048];
        int[] xorTriplet = new int[2048];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                xorPair[nums[i] ^ nums[j]] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2048; j++) {
                if (xorPair[j] == 1) {
                    xorTriplet[j ^ nums[i]] = 1;
                }
            }
        }

        int count = 0;
        for (int value : xorTriplet) {
            if (value == 1) {
                count++;
            }
        }

        return count;
    }
}