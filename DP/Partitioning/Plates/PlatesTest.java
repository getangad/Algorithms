package DP.Partitioning.Plates;

import org.junit.Assert;
import org.junit.Test;

public class PlatesTest {

    @Test
    public void testPlates() {
        Plates plates = new Plates();
        int[][] platesStack = new int[][] {
            {10, 10, 100, 30},
            {80, 50, 10, 50}
        };
        int resultUsingRecursion = plates.getMaximumValueUsingRecursion(platesStack,   5 );
        int resultUsingDp = plates.getMaximumValueUsingDp(platesStack,   5 );
        Assert.assertEquals(250, resultUsingRecursion);
        Assert.assertEquals(250, resultUsingDp);
    }
    
}
