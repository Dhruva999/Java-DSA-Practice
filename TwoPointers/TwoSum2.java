
import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-based indices as required by LeetCode
                return new int[]{left + 1, right + 1};
            }

            else if (sum < target) {
                // Sum is too small; move left pointer forward
                left++;
            }

            else {
                // Sum is too large; move right pointer backward
                right--;
            }
        }

        // Return empty array if no valid pair exists
        return new int[]{};
    }

    public static void main(String[] args) {

        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(numbers, target);

        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Target: " + target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}

/*
TIME COMPLEXITY: O(n)
- In each iteration, either left or right moves.
- Each pointer moves at most n times in total.

SPACE COMPLEXITY: O(1)
- Only two pointers and a constant-size result are used.
- The returned array contains exactly two indices when a solution exists.
*/
