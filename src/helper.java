import java.util.Dictionary;
import java.util.Hashtable;

public class helper {
    // Counts number of Characters in a String
    public static Hashtable<Character, Float> countChars(String word) {
        StringBuilder s = new StringBuilder();
        Hashtable<Character, Float> charCounts = new Hashtable<>();

        for (char c : word.toCharArray()) {
            int i = 0;

            if (s.toString().indexOf(c) < 0) {
                for (char b : word.toCharArray()) {
                    if (b == c) {
                        i++;
                    }
                }
                s.append(c);
                float rel = ((float) i / word.length())*100;
                rel = ((float) Math.round(rel * 100) /100);
                //System.out.println(rel);
                charCounts.put(c, rel);
            }
        }
        return charCounts;
    }

    public static boolean checkIfLetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
