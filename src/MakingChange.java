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
        // Each index represents a target value.
        // Each value represents the # of ways to create the index
        long[] numWays = new long[target + 1];
        // Count represents the # of ways to achieve the target

        numWays[target] = coinRecurse(target, coins[0], 0, coins, numWays);

        for (int i = 0; i < numWays.length; i++){
            System.out.println(i + " " + numWays[i]);
        }
        return numWays[target];
    }

    public static long coinRecurse(int target, int total, int currentIndex, int[] coins, long[] numWays){
        // Base case — if value is greater than target, it's not a valid solution
        if (total > target){
            return -1;
        }
        // Base case — if target is reached
        if (total == target){
            return 1;
        }
        // Base case — if value is in coinCount, skip redundant recursion
        if (numWays[total] >= 0){
            return numWays[total];
        }

        // Recurse for all coins of greater values
        for (int i = currentIndex; i < coins.length; i++){
            // Saves num ways to get to this new value
            numWays[total] += coinRecurse(target, total + coins[i], i, coins, numWays);
        }
        return numWays[total];
    }
}
