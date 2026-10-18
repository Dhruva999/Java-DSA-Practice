
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Frequency array for 26 lowercase English letters
        int[] freq = new int[26];

        // Count characters in s and subtract characters in t
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If all frequencies are zero, strings are anagrams
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        if (isAnagram(s, t)) {
            System.out.println("Valid Anagram");
        } else {
            System.out.println("Not a Valid Anagram");
        }
    }
}
