class Solution {
    public long countCommas(long n) {
        
        if(n < 1000) return 0;
        if(n >= 1000 && n < 1000000) return n - 999;
        if(n >= 1000000 && n < 1000000000) return (2 * (n - 999999)) + countCommas(999999);
        if(n >= 1000000000L && n < 1000000000000L) return (3 * (n - 999999999L)) + countCommas(999999999L);
        if(n >= 1000000000000L && n < 1000000000000000L) return (4 * (n - 999999999999L)) + countCommas(999999999999L);

        return (5 * (n - 999999999999999L)) + countCommas(999999999999999L);
    }
}