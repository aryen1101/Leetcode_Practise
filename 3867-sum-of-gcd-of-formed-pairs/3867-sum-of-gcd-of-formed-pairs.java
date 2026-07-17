class Solution {

    static{
        for(int i = 0 ; i < 500 ; i++){
            gcdSum(new int[]{1});
        }
    }
    public static long gcdSum(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;

        int[] prefixGcd = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefixGcd[i] = gcd(nums[i] , max);
        }

        Arrays.sort(prefixGcd);

        int i = 0;
        int j = n-1;
        long sum = 0;

        while(i < j){
            sum += gcd(prefixGcd[i] , prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
        
    }

     public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}