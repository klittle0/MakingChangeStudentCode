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
        // Arraylist of lists — each list will be of length coins
        // Each index will represent the # of each type of coin
        ArrayList<int[]> solutions = new ArrayList<>();
        int[] maxCounts = new int[coins.length];
        // Sort in ascending order
        Arrays.sort(coins);

        //Fill in max counts, which represents the max # of each coin that can fit in target
        for (int i = coins.length - 1; i >= 0 ; i--){
            int numCoin = 0;
            // Finds max # of this coin that can fit into target
            while (numCoin * coins[i] < target){
                numCoin++;
            }
            maxCounts[i] = numCoin;
        }

        //Rely on MaxCounts to find all solutions:
        for (int i = 0; i < coins.length; i++){
            for (int j = 0; j < coins[i]; j++){
                // Try to find all solutions w/ all values of these coins
                int[] current = new int[coins.length];
                current[i] = j;
                coinRecurse(target, j * coins[i], coins, current, solutions);
            }
        }
        return 0;
    }


    //Pseudocode:
    //start w/ a coin type & see how many of that type you can fit
    // Then, go to the next coin type & try to fill in the gaps
    // If not possible, go to the next

    // Or maybe I should do a recursive method...I could basically just go through each type of coin, see how

    public static void coinRecurse(int target, int total, int[] coins, int[] current, ArrayList<int[]> solutions){
        // Base case — if target is reached
        if (total == target){
            solutions.add(current);
        }
        // Base case — if it's not possible to reach the target w/ current values, return

        // for
    }

}
