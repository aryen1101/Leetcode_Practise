class Solution {
    public int smallestNumber(int n, int t) {

        int num = n;
        while(true){
            if(getProduct(num) % t == 0) return num;
            num++;
        }
        
    }
    
    public int getProduct(int num){

        int total = 1;
        while(num > 0){
            int rem = num % 10;
            total *= rem;
            num /= 10;
        }

        return total;
    }
}