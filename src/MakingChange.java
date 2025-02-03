import java.util.Arrays;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Kate Little
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */
    public static long countWays(int target, int[] coins) {
        // Sort coins arrays
        Arrays.sort(coins);
        // 2d array to save recursive calls & reduce redundancy
        // Memoization approach!
        int[][] numWays = new int[target][coins.length];

        return coinCount(target, 0, coins, numWays);
    }

    public static long coinCount(int target, int currentIndex, int[] coins, int[][] numWays){
        // Memoization Base case — if this call is saved in numWays, return that value without recursing
        if (numWays[target][currentIndex] != 0){
            return numWays[target][currentIndex];
        }
        // Base case — If sum is negative, it's not a valid solution
        if (target < 0){
            return 0;
        }
        // Base case — if smallest possible sum is reached
        if (target == 0){
            numWays[target][currentIndex] = 1;
            return 1;
        }
        // Base case — if index is out of bounds
        if (currentIndex >= coins.length){
            return 0;
        }

        // Recurse
        return coinCount(target - coins[currentIndex], currentIndex, coins, numWays) +
                coinCount(target, currentIndex + 1, coins, numWays);

    }
}
