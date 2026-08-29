class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr);
        List<List<Integer>> groups = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int id = -1;

        for(int i = 0 ; i < arr.length ; i++){
            if(i == 0 || arr[i] - arr[i-1] > limit){
                groups.add(new ArrayList<>());
                id++;
            }

            groups.get(id).add(arr[i]);
            map.put(arr[i] , id);
        }

        int[] pointer = new int[groups.size()];

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int groupId = map.get(nums[i]);

            ans[i] = groups.get(groupId).get(pointer[groupId]);

            pointer[groupId]++;
        }

        return ans;







    }
}