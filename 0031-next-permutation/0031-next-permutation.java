class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        int index1 = -1;

        for(int i = n - 1 ; i > 0 ; i--){
            if(nums[i] > nums[i-1]){
                index1 = i-1;
                break;
            }
        }

        if(index1 == -1){
            reverse(nums, 0);
            return;
        }

        int index2 = -1;
        for(int i = n - 1 ; i > index1 ; i--){
            if(nums[i] > nums[index1]){
                index2 = i;
                break;
            }
        }

        swap(nums, index1, index2);
        reverse(nums, index1+1);

        
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int start){

        int end = arr.length - 1;
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}