
import java.util.*;

public class EncodeDecode {

    // Encodes a list of strings into a single string
    public static String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {

            // Append string length, delimiter, and string
            encoded.append(str.length())
                   .append("#")
                   .append(str);
        }

        return encoded.toString();
    }

    // Decodes the encoded string back into the original list
    public static List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find the delimiter separating length from string
            int delimiter = s.indexOf('#', i);

            // Parse the length of the next string
            int length = Integer.parseInt(
                s.substring(i, delimiter)
            );

            // Move i to the beginning of the actual string
            i = delimiter + 1;

            // Extract exactly 'length' characters
            String str = s.substring(i, i + length);

            result.add(str);

            // Move i to the beginning of the next encoded string
            i = i + length;
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> original = Arrays.asList(
            "hello",
            "world",
            "",
            "java#coding",
            "123"
        );

        String encoded = encode(original);
        List<String> decoded = decode(encoded);

        System.out.println("Original List: " + original);
        System.out.println("Encoded String: " + encoded);
        System.out.println("Decoded List: " + decoded);
        System.out.println("Match: " + original.equals(decoded));
    }
}

/*
TIME COMPLEXITY:
Encode: O(N)
Decode: O(N)
N = total number of characters across all strings,
    plus the encoding metadata.

SPACE COMPLEXITY:
Encode: O(N) for the encoded string.
Decode: O(N) for the decoded list and its strings.
*/
