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
        System.out.println(Knapsack.usingRecursion(weight, profit, knapsackWeight, weight.length - 1));

        System.out.println(Knapsack.usingDynamicProgramming(weight, profit, knapsackWeight));
    }
}

class Knapsack {
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

        for (int i = 1; i < dp.length; i++) {

            for (int j = 1; j < dp[i].length; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }

        return dp[profit.length][knapsackWeight];
    }

}