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

class Main {
    public static void main(String[] args) {

        int[] weight = new int[] { 3, 4, 47, 7 };
        int[] profit = new int[] { 10, 2, 3, 7 };
        int knapsackWeight = 8;
        System.out.println(KnapsackZeroOne.usingRecursion(weight, profit, knapsackWeight, weight.length - 1));

        System.out.println(KnapsackZeroOne.usingDynamicProgramming(weight, profit, knapsackWeight));
    }
}

class KnapsackZeroOne {
    public static int usingRecursion(int[] weight,
            int[] profit,
            int knapsackWeight,
            int n) {

        // if items are completed or knapsack is full then return 0
        if (n < 0 || knapsackWeight == 0) {
            return 0;
        }

        // if weight of the item is more than the bag
        if (weight[n] > knapsackWeight) {
            return usingRecursion(weight, profit, knapsackWeight, n - 1);
        }

        // check max profit if item is included or not included
        return Math.max(profit[n] + usingRecursion(weight, profit, knapsackWeight - weight[n], n - 1),
                usingRecursion(weight, profit, knapsackWeight, n - 1));
    }

    public static int usingDynamicProgramming(int[] weight,
            int[] profit,
            int knapsackWeight) {

        int[][] dp = new int[profit.length + 1][knapsackWeight + 1];

        for (int elementIndex = 1; elementIndex < dp.length; elementIndex++) {

            for (int requiredWeight = 1; requiredWeight < dp[elementIndex].length; requiredWeight++) {
                if (weight[elementIndex - 1] > requiredWeight) {
                    dp[elementIndex][requiredWeight] = dp[elementIndex - 1][requiredWeight];
                } else {
                    dp[elementIndex][requiredWeight] = Math.max(profit[elementIndex - 1] + dp[elementIndex - 1][requiredWeight - weight[elementIndex - 1]], dp[elementIndex - 1][requiredWeight]);
                }
            }
        }

        return dp[profit.length][knapsackWeight];
    }


    public static int usingDpTest(int weights[], int values[], int knapsackWeight) {
        int[][] dp = new int[values.length+1][knapsackWeight+1];

        for (int i = 1; i < dp.length; i++) { //iterate over items
            for (int w = 1; w < dp[i].length; w++) { // iterate over weights
                if (w < weights[i-1]) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    // check if the item is included
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i - 1][w - weights[i-1]]);
                }
            }
        }
        

        return dp[values.length][knapsackWeight];
    }

}