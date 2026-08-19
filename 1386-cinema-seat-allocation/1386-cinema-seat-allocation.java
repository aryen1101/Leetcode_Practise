class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        int filledRows = 0;
        boolean A = true, B = true, C = true;

        for(int[] seat: reservedSeats) {
            if(!map.containsKey(seat[0])){
                map.put(seat[0], new ArrayList<>());
            }

            map.get(seat[0]).add(seat[1]);
        }

        for(int key : map.keySet()){
            A = true;
             B = true;
              C = true;
            filledRows++;

            for(int val : map.get(key)){
                if(val == 2 || val == 3 || val == 4 || val == 5) A = false;
                if(val == 4|| val == 5 || val == 6 || val == 7) B = false;
                if(val == 6 || val == 7 || val ==8 || val == 9) C = false;
            }

            if(A && C) total += 2;
            else if(A || B || C) total += 1;

        }

        total += (n - filledRows) * 2;
        return total;
    }
}