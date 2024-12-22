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

    public static int usingDynamicProgramming(int[] weight,
            int[] profit,
            int knapsackWeight) {


                return 0;
    }


   
}