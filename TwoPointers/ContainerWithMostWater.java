public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            // Width between the two lines
            int width = right - left;

            // Water height is limited by the shorter line
            int minHeight = Math.min(height[left], height[right]);

            // Calculate the area of water
            int area = width * minHeight;

            maxWater = Math.max(maxWater, area);

            // Move the pointer at the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = maxArea(height);

        System.out.println("Maximum water area: " + result);
    }
}

/*
Time Complexity: O(n)
    - Two pointers move toward each other.
    - Each pointer moves at most n times combined.

Space Complexity: O(1)
    - Only a constant number of variables are used.
*/
