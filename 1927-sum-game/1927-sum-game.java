class Solution {
    public boolean sumGame(String num) {
        int n = num.length();

        int leftSum = 0, rightSum = 0;
        int leftQues = 0, rightQues = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?')
                leftQues++;
            else
                leftSum += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?')
                rightQues++;
            else
                rightSum += num.charAt(i) - '0';
        }

        return (leftSum - rightSum) != (rightQues - leftQues) * 4.5;
    }
}