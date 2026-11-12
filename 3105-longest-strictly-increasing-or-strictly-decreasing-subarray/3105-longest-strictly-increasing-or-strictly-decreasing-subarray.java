
class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        if(nums.length == 1) return 1;

        int count = 1;
        boolean increasing = false;
        int max = 1;

        if(nums[1] > nums[0]){
            increasing = true;
            count++;
        }
        else if(nums[0] > nums[1]){
            count++;
            increasing = false;
        }

        max = Math.max(count, max);

        for(int i = 2; i < nums.length; i++){

            if(nums[i] > nums[i-1] && increasing){
                count++;
            }
            else if(nums[i] > nums[i-1] && !increasing){
                increasing = true;
                count = 2;
            }
            else if(nums[i] < nums[i-1] && !increasing){
                count++;
            }
            else if(nums[i] < nums[i-1] && increasing){
                increasing = false;
                count = 2;
            }
            else{
                count = 1;
                increasing = false;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
