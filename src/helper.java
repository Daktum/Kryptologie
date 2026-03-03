public class helper {

    // Counts number of Characters in a String
    public static double[] countChars(String word) {
        StringBuilder s = new StringBuilder();
        double[] charCounts = new double[26];

        for (char c : word.toCharArray()) {
            int i = 0;

            if (s.toString().indexOf(c) < 0) {
                for (char b : word.toCharArray()) {
                    if (b == c) {
                        i++;
                    }
                }
                s.append(c);
                double rel = ((double) i / word.length())*100;
                rel = ((double) Math.round(rel * 100) /100);

                charCounts[c-65] = rel;
                //System.out.println(Arrays.toString(charCounts));
            }
        }

        return charCounts;
    }

    public static double[] berechneRelativeHaeufigkeiten(String text) {
        int[] absH = new int[26];
        double[] relH = new double[26];
        int anzahl = 0;
        for (char buchstabe : text.toCharArray()) {
            absH[buchstabe - 65]++;
            anzahl++;
        }
        for (int pos = 0; pos < 26; pos++) {
            relH[pos] = 100.0 * absH[pos] / anzahl;
        }
        return relH;
    }

    //public static boolean checkIfLetter(char c) {
    //    return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    //}

    public static String makeUsebleString(String word){

        StringBuilder out = new StringBuilder();

        word = word.toUpperCase();

        for ( char c : word.toCharArray()){
            if (Character.isLetter(c)){
                out.append(c);
            }
        }

        return out.toString();
    }
}
