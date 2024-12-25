import java.util.HashSet;
import java.util.Set;

/**
 * 0-1 Knapsack Problem
 * 4, 4, 4
 * Wts = [4,3,46,7]
 * Colors = [1,2,2,3]
 * 
 * Knapsack weight = 8
 * 
 */

/*
 * I have to get all colors and the weights should not be greater than 8, get the maximum weight
 * 
 */

class KnapsackColorful {
    public int usingRecursion(int[] weight,
            int[] colors,
            int knapsackWeight, 
            int maxColors) {

        // if items are completed or knapsack is full then return 0
        if (knapsackWeight == 0) {
            return -1;
        }

        return this.usingRecursion(weight, colors, knapsackWeight, maxColors, weight.length - 1, new HashSet<>());
    }

    private int usingRecursion(
    int[] weight,
    int[] colors,
    int knapsackWeight, 
    int maxColors,
    int index,
    Set<Integer> stonesOfColor) {
        if (knapsackWeight >= 0 && maxColors == stonesOfColor.size()) {
            return knapsackWeight;
        }
        if (knapsackWeight < 0 || index < 0) {
            return -1;
        }
      
        int includeColor = -1;
        int excludeColor = -1;
        // include
        if (!stonesOfColor.contains(colors[index])) {
            Set<Integer> newStonesOfColor = new HashSet<>(stonesOfColor);
            newStonesOfColor.add(colors[index]);
            includeColor = usingRecursion(  weight, 
                                            colors, 
                                            knapsackWeight - weight[index], 
                                            maxColors, 
                                            index - 1, 
                                            newStonesOfColor);
        }

        excludeColor = usingRecursion(  weight, 
                                        colors, 
                                        knapsackWeight, 
                                        maxColors, 
                                        index - 1, 
                                        stonesOfColor); 
        return Math.max(includeColor, excludeColor);
    }

}