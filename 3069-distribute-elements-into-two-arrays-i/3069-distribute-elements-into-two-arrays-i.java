class Solution {
    public int[] resultArray(int[] nums) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i = 2 ; i < nums.length ; i+=1){
            if(arr1.get(arr1.size()-1) > arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }

        int[] result = new int[arr1.size() + arr2.size()];
        int i = 0;
        for(int val : arr1){
            result[i] = val;
            i++;
        }

        for(int val : arr2){
            result[i] = val;
            i++;
        }

        return result;
        
    }
}