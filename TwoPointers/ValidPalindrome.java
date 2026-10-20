
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters ignoring case
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(s);

        System.out.println("Input: " + s);
        System.out.println("Is Palindrome: " + result);
    }
}

/*
TIME COMPLEXITY: O(n)
- Each character is visited at most a constant number of times.
- n = length of the string.

SPACE COMPLEXITY: O(1)
- Only two pointers are used.
- No additional string or array is created.
*/
