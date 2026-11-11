class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        
       long pair = Math.min(need1 , need2);
       long pairTotal = Math.min(cost1 + cost2 , costBoth) * pair;
       long rem1 = need1 - pair;
       long rem2 = need2 - pair;
       long rem = (rem1 == 0) ? rem2 : rem1;
       long cost = (rem1 == 0) ? cost2 : cost1;
       pairTotal += (rem * Math.min(cost, costBoth));
       return pairTotal;
    }
}