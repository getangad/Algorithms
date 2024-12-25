package DP;

import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... 
 * Find the minimum cost to paint all houses.
 * 
 * Note:
 * All costs are positive integers.
 * Example:
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Input: [[17,2,17],[18,33,7],[21,10,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
             Minimum cost: 2 + 5 + 3 = 10.

 */
public class PaintHouse {
   public int getMinimumCostUsingRecursion(int[][] houseAndColorCost) {
    int result = this.getMinimumCostUsingRecursion(houseAndColorCost, 0, -1);
    return result == Integer.MAX_VALUE ? -1 : result;
   }
   
   private int getMinimumCostUsingRecursion(int[][] houseAndColorCost, int houseIndex, int previousColorIndex) {
    if (houseIndex >= houseAndColorCost.length) {
        return 0;
    }
    int minCost = Integer.MAX_VALUE;
    for (int colorIndex = 0; colorIndex < houseAndColorCost[houseIndex].length; colorIndex++) {
        if (colorIndex != previousColorIndex) {
            minCost = Math.min(minCost, houseAndColorCost[houseIndex][colorIndex] + getMinimumCostUsingRecursion(houseAndColorCost, houseIndex + 1, colorIndex));
        }
    }
    return minCost;
   }


   public int getMinimumCostUsingDP(int[][] houseAndColorCost) {
    int dp[][] = new int[houseAndColorCost.length][houseAndColorCost[0].length];
    
    for (int houseIndex = 0; houseIndex < houseAndColorCost.length; houseIndex++) {
        for (int colorIndex = 0; colorIndex < houseAndColorCost[houseIndex].length; colorIndex++) {  
            dp[houseIndex][colorIndex] = houseAndColorCost[houseIndex][colorIndex] + getMinimumOfHouseExcludingAColorIndex(dp, houseIndex - 1, colorIndex);
        }
    }
    return Arrays.stream(dp[houseAndColorCost.length - 1]).min().getAsInt();
   }

   private int getMinimumOfHouseExcludingAColorIndex(int[][] dp, int houseIndex, int filteredOutcolorIndex) {
    if (houseIndex < 0) {
        return 0;
    }
    int value = Integer.MAX_VALUE;
    for (int colorIndex = 0; colorIndex < dp[houseIndex].length; colorIndex++) {
        if (colorIndex != filteredOutcolorIndex) {
            value = Math.min(value, dp[houseIndex][colorIndex]);
        }
    }
    return value == Integer.MAX_VALUE? 0 :value;
   } 


}
