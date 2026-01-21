import java.util.Dictionary;
import java.util.Hashtable;

public class helper {

    // Counts number of Characters in a String
    public static Dictionary<Character, Integer> countChars(String word) {
        StringBuilder s = new StringBuilder();

        Dictionary<Character, Integer> charCounts = new Hashtable<>();

        for (char c : word.toCharArray()) {
            int i = 0;

            if (s.toString().indexOf(c) < 0) {
                for (char b : word.toCharArray()) {
                    if (b == c) {
                        i++;
                    }
                }
                s.append(c);
                charCounts.put(c, i);
            }
        }
        return charCounts;
    }

}
