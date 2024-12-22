public class LongestIncreasingSubsequence {
    
    public int getLongestIncreasingSubsequenceLength(int[] sequence) {

        int[] dp = new int[sequence.length];
        int maxLength = 0;
        for (int i=sequence.length - 1; i >= 0; i--) {
            dp[i] = 1;
            boolean isLast = i == sequence.length - 1;
            if (!isLast && sequence[i+1]>sequence[i]) {
                dp[i] = dp[i + 1] + 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
