class Solution {
    public void sortColors(int[] A) {

        int n = A.length;
        int start = 0;
        int mid = 0;
        int end = n - 1;


        while(mid <= end){

            if(A[mid] == 0){
                int temp = A[mid];
                A[mid] = A[start];
                A[start] = temp;
                start++;
                mid++;
            }

            else if(A[mid] == 1){
                mid++;
            }

            else{
                int temp = A[mid];
                A[mid] = A[end];
                A[end] = temp;
                end--;
            }
        }
    }

    public void swap(int a, int b){

        int temp = a;
        a = b;
        b = temp;
    }
}