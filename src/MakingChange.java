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
        int[] numWays = new int[target + 1];
        // Count represents the # of ways to achieve the target
        long count = 0;
        for (int i = 0; i < coins.length; i++){
            numWays[target] = coinRecurse(target, i, coins, numWays);
        }

        for (int i = 0; i < numWays.length; i++){
            System.out.println(i + " " + numWays[0]);
        }
        return numWays[target];
    }

    public static int coinRecurse(int target, int currentIndex, int[] coins, int[] numWays){
        // Base case — if value is greater than target, it's not a valid solution
        if (target < 0){
            return 0;
        }
        // Base case — if value is in coinCount, skip redundant recursion
        if (numWays[target] != 0){
            return numWays[target];
        }
        // Base case — if target is reached
        if (target == 0){
            return 1;
        }

        // Dynamic programming — save # of ways to achieve this total — except I'm not actively saving
        //numWays[total] = total;

        // Recurse for all coins of greater values
        int count = 0;
        for (int i = currentIndex; i < coins.length; i++){
            // Saves num ways to get to this new value
            numWays[target - coins[i]] = coinRecurse(target - coins[i], i, coins, numWays);
        }
        return count;
    }
}
