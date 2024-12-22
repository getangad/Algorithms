import org.junit.Assert;
import org.junit.Test;


public class KnapsackZeroNTest {

    @Test()
    public void testKnapsack() {
        int[] weight = new int[] {3,4,47,7};
        int[] profit = new int[] {10,2,3,7};
        int knapsackWeight  = 8;
        KnapsackZeroN knapsackZeroN = new KnapsackZeroN();
        int resultUsingRecursion = knapsackZeroN.usingRecursion(weight, profit, knapsackWeight);
        Assert.assertEquals(20, resultUsingRecursion);
    }   
}
