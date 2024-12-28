/**
 * 0-1 Knapsack Problem
 * Wts = [4,3,46,7]
 * Profit = [1,2,3,7]
 * 
 * Knapsack weight = 6
 * 
 */

/*
 * 
 * if weight is more than k then dont include.
 * 
 * 
 */

class KnapsackZeroN {
    public int usingRecursion(int[] weight,
            int[] profit,
            int knapsackWeight) {
                if (knapsackWeight == 0) {
                    return 0;
                }

                return usingRecursion(weight, profit, knapsackWeight, weight.length - 1);
    }

    private int usingRecursion(int[] weight,
            int[] profit,
            int knapsackWeight,
            int itemIndex) {
                if (knapsackWeight <= 0 || itemIndex < 0) {
                    return 0;
                }
                int includeValue = 0;
                //include value
                if (knapsackWeight >= weight[itemIndex])
                    includeValue = profit[itemIndex] + usingRecursion(weight, profit, knapsackWeight-weight[itemIndex], itemIndex);
                //exclude
                int excludeValue = usingRecursion(weight, profit, knapsackWeight, itemIndex - 1);

                return Math.max(includeValue, excludeValue);
            }


    /**
     * For DP in Knapsack
     * Use number of items as rows
     * Use weights as columns
     * 
     * 
     * 
     * @param weight
     * @param profit
     * @param knapsackWeight
     * @return
     */
    public static int usingDynamicProgramming(int[] weight,
            int[] profit,
            int knapsackWeight) {
                int[][] dp = new int[weight.length+1][knapsackWeight+1];

                for (int itemIndex = 1; itemIndex <= weight.length; itemIndex++) {
                    for (int requiredWeight = 1; requiredWeight<=knapsackWeight; requiredWeight++) {
                        
                        if (weight[itemIndex - 1] < requiredWeight) {
                            dp[itemIndex][requiredWeight] = profit[itemIndex - 1] + dp[itemIndex][requiredWeight - weight[itemIndex - 1]];
                        }
                        dp[itemIndex][requiredWeight] = Math.max(dp[itemIndex][requiredWeight], dp[itemIndex - 1][requiredWeight]);
                    }
                }
                return dp[weight.length][knapsackWeight];
    }


   
}