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
