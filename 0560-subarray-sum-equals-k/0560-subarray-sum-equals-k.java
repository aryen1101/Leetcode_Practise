class Solution {
    public int subarraySum(int[] nums, int K) {
        int N = nums.length;
        int[] prefix = new int[N];
        prefix[0]=nums[0];
        for(int i=1;i<N;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }

        int ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        for(int i=0;i<N;i++){
            if(map.containsKey(prefix[i]-K)){
                ans += map.get(prefix[i]-K);
            }
            if(map.containsKey(prefix[i])){
                map.put(prefix[i] , map.get(prefix[i])+1);
            }
            else{
                map.put(prefix[i] , 1);
            }
        }
        return ans;
        
    }
}