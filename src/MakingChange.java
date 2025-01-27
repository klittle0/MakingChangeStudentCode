import java.util.ArrayList;
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
        long count = 0;
        for (int i = 0; i < coins.length; i++){
            count += coinRecurse(target, coins[i], i, coins);
        }
        return count;
    }

    // Or maybe I should do a recursive method...I could basically just go through each type of coin, see how

    public static int coinRecurse(int target, int total, int currentIndex, int[] coins, int[] coinCount){
        // Base case — if target is reached
        if (total == target){

            return 1;
        }
        // Base case — if value is greater than target, it's not a valid solution
        if (total > target){
            // Correct return statement?
            return 0;
        }
        // Recurse
        int count = 0;
        for (int i = currentIndex; i < coins.length; i++){
            count += coinRecurse(target, total + coins[i], i, coins);
        }
        return count;
    }

}
