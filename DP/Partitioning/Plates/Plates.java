package DP.Partitioning.Plates;

public class Plates {

    public int getMaximumValueUsingRecursion(int[][] platesStack, int numberOfPlatesRequired) {
        if (platesStack.length == 0 || platesStack[0].length==0) {
            //return invalid scenario
            return 0;
        }
        int[][] stackValueArray = this.getStackCumulativeSumArray(platesStack);



        return this.solveRecursively(stackValueArray, numberOfPlatesRequired, 0);
    }
    
    
    public int getMaximumValueUsingDp(int[][] platesStack, int numberOfPlatesRequired) {
        if (platesStack.length == 0 || platesStack[0].length==0) {
            //return invalid scenario
            return 0;
        }
        int[][] cumulativeSumArray = this.getStackCumulativeSumArray(platesStack);
        int[][] dp = new int[cumulativeSumArray.length][numberOfPlatesRequired+1]; //rows will be stackIndex and columns will be the number of plates required
        

        /**
         * 10 20 120 150
         * 80 130 140 190
         * 
         * 
         * 
         
        
        
        
         *      0   1   2   3   4   5
         * 1    0   10  20  120 150 0
         * 2    0   80  130 140 190 250
         * 3
         * 4
         * 
         */

         for (int stackIndex = 0; stackIndex < cumulativeSumArray.length; stackIndex++) {
            for (int plateIndex = 1; plateIndex <= numberOfPlatesRequired; plateIndex++) {

                if (stackIndex == 0) {
                    dp[stackIndex][plateIndex] = plateIndex > cumulativeSumArray[stackIndex].length? 0: cumulativeSumArray[stackIndex][plateIndex - 1];
                } else {
                    int max = plateIndex > cumulativeSumArray[stackIndex].length?0:cumulativeSumArray[stackIndex][plateIndex - 1];
                    for (int i = 0; i<=plateIndex; i++) {
                        max = Math.max(max, dp[stackIndex][i]+dp[stackIndex-1][plateIndex - i]);
                    }
                    dp[stackIndex][plateIndex] = max;
                }

            }
         }
         return dp[cumulativeSumArray.length-1][numberOfPlatesRequired];
    }
    
    
    /**
     * for each stack we will have to check the number of plates
     */
    private int solveRecursively(int[][] cumulativeSum, int numberOfPlatesRequired, int stackIndex) {   
        int max = 0;
        if (stackIndex >= cumulativeSum.length || numberOfPlatesRequired == 0) {
            return 0;
        }
        for (int i=0; i<=numberOfPlatesRequired && i < cumulativeSum[stackIndex].length ; i++) {
            // take i number of plates from this stack
            if (i == 0) {
                max = Math.max(max, solveRecursively(cumulativeSum, numberOfPlatesRequired - i, stackIndex + 1));
            } else {
                max = Math.max(max, cumulativeSum[stackIndex][i - 1] + solveRecursively(cumulativeSum, numberOfPlatesRequired - i, stackIndex + 1));
            }
        }

        return max;
    }

    private int[][] getStackCumulativeSumArray(int[][] platesStack) {
        int[][] stackValueArray = new int[platesStack.length][platesStack[0].length];
        for (int i = 0; i < stackValueArray.length; i++) {
            for (int j = 0; j < stackValueArray[i].length; j++) {
                if (j==0) {
                    stackValueArray[i][j] = platesStack[i][j];
                } else {
                    stackValueArray[i][j] = stackValueArray[i][j-1] + platesStack[i][j];
                }
            }
        }
        return stackValueArray;
    }
    
}
