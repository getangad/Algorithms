import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;


public class KnapsackColorfulTest {

    @Test()
    public void testKnapsack() {
        int[] weight = new int[] {3,4,47,7};
        int[] colors = new int[] {1,2,2,3};
        int knapsackWeight  = 15;
        int maxColors = 3;
        KnapsackColorful knapsackColorful = new KnapsackColorful();
        int resultUsingRecursion = knapsackColorful.usingRecursion(weight, colors, knapsackWeight, maxColors);
        
        
        Assert.assertEquals(1, resultUsingRecursion);
    }   

    @Test()
    public void testKnapsackFailure() {
        int[] weight = new int[] {3,4,47,7};
        int[] colors = new int[] {1,2,2,3};
        int knapsackWeight  = 13;
        int maxColors = 3;
        KnapsackColorful knapsackColorful = new KnapsackColorful();
        int resultUsingRecursion = knapsackColorful.usingRecursion(weight, colors, knapsackWeight, maxColors);
        
        
        Assert.assertEquals(-1, resultUsingRecursion);
    } 

    @Test()
    public void testKnapsackBoundary() {
        int[] weight = new int[] {3,4,47,7};
        int[] colors = new int[] {1,2,2,3};
        int knapsackWeight  = 14;
        int maxColors = 3;
        KnapsackColorful knapsackColorful = new KnapsackColorful();
        int resultUsingRecursion = knapsackColorful.usingRecursion(weight, colors, knapsackWeight, maxColors);
        
        
        Assert.assertEquals(1, resultUsingRecursion);
    } 
}
