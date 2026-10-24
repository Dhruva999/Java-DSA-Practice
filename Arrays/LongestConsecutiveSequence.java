
import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start counting only if num is the beginning
            // of a consecutive sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive elements
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Longest consecutive sequence length: " + result);
    }
}

/*
Time Complexity: O(n) average
    - Inserting n elements into HashSet takes O(n) average.
    - Each consecutive sequence is traversed only from its beginning.
    - Each element is visited a constant number of times overall.

Space Complexity: O(n)
    - HashSet stores up to n distinct elements.
*/
