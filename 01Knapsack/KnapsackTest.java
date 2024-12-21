import org.junit.Assert;
import org.junit.Test;


public class KnapsackTest {

    @Test()
    public void testKnapsack() {
        int[] weight = new int[] {3,4,47,7};
        int[] profit = new int[] {10,2,3,7};
        int knapsackWeight  = 8;
        int resultUsingRecursion = Knapsack.usingRecursion(weight, profit, knapsackWeight, weight.length - 1);
        int resultUsingDp = Knapsack.usingDynamicProgramming(weight, profit, knapsackWeight);
        int resultUsingTest = Knapsack.usingDpTest(weight, profit, knapsackWeight);
        Assert.assertEquals(resultUsingDp, resultUsingRecursion);
        Assert.assertEquals(12, resultUsingDp);
        Assert.assertEquals(12, resultUsingTest);
    }   
}
