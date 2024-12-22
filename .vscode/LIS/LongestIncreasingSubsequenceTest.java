import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
    
    @Test
    public void testGetLongestIncreasingSubsequenceLength() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int result = lis.getLongestIncreasingSubsequenceLength(new int[]{3,1,2,3,4,5,6,7,2,11,14});
        Assert.assertEquals(7, result);
    }

    @Test
    public void testGetLongestIncreasingSubsequenceLengthWhenAnswerIsOne() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int result = lis.getLongestIncreasingSubsequenceLength(new int[]{4,3,2,1});
        Assert.assertEquals(1, result);
    }

    @Test
    public void testGetLongestIncreasingSubsequenceLengthWhenAnswerIsFour() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int result = lis.getLongestIncreasingSubsequenceLength(new int[]{1,2,3,4});
        Assert.assertEquals(4, result);
    }
}
