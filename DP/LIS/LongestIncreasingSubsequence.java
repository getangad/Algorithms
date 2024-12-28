public class LongestIncreasingSubsequence {
    // Input [1,22,43,5,7,100,8, 92]
    // LIS 1,5,7,8,92



    
    public int getLongestIncreasingSubsequenceLength(int[] sequence) {
        int[] dp = new int[sequence.length];
        int maxLength = 0;
        for (int i=sequence.length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[j]>sequence[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }
}
