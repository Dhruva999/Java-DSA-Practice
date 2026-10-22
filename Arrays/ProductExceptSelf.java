
import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Store prefix products
        // result[i] = product of all elements to the left of i
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply by suffix products
        // rightProduct = product of all elements to the right of i
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            result[i] = result[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + Arrays.toString(result));
    }
}

/*
TIME COMPLEXITY: O(n)
- One pass to calculate prefix products.
- One pass to calculate suffix products.

SPACE COMPLEXITY: O(1) AUXILIARY SPACE
- Only a few variables are used apart from the output array.
- The output array is not counted as extra space, as is standard
  for this problem.
*/
