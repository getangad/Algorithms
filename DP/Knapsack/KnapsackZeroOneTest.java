import org.junit.Assert;
import org.junit.Test;


public class KnapsackZeroOneTest {

    @Test()
    public void testKnapsack() {
        int[] weight = new int[] {3,4,47,7};
        int[] profit = new int[] {10,2,3,7};
        int knapsackWeight  = 8;
        int resultUsingRecursion = KnapsackZeroOne.usingRecursion(weight, profit, knapsackWeight, weight.length - 1);
        int resultUsingDp = KnapsackZeroOne.usingDynamicProgramming(weight, profit, knapsackWeight);
        int resultUsingTest = KnapsackZeroOne.usingDpTest(weight, profit, knapsackWeight);
        Assert.assertEquals(resultUsingDp, resultUsingRecursion);
        Assert.assertEquals(12, resultUsingDp);
        Assert.assertEquals(12, resultUsingTest);
    }   
}
