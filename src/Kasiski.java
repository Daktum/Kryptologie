import java.util.*;

public class Kasiski {

    public static final double[] GER = {6.51, 1.89, 3.06, 5.08, 17.4, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7.00, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13};
    public static final double[] FRA = {7.64, 0.90, 3.26, 3.67, 14.72, 1.06, 0.87, 0.74, 7.53, 0.61, 0.05, 5.46, 2.97, 7.10, 5.38, 3.02, 1.36, 6.55, 7.95, 7.24, 6.31, 1.83, 0.04, 0.42, 0.19, 0.21};


    public static ArrayList<Integer> findRepeatedSequenceDistances(String word) {

        ArrayList<Integer> distances = new ArrayList<>();

        for (int seqLength = 3; seqLength <= 5; seqLength++) {
            for (int seqStart = 0; seqStart < word.length() - seqLength; seqStart++) {
                String seq = word.substring(seqStart, seqStart + seqLength);
                for (int secSeqStart = seqStart + seqLength; secSeqStart < word.length() - seqLength; secSeqStart++) {
                    if (word.startsWith(seq, secSeqStart)) {
                        int dist = secSeqStart - seqStart;
                        if (!distances.contains(seq)) {
                            distances.add(dist);
                        }
                    }
                }
            }
        }

        return distances;
    }

    public static Integer keyWordLength(ArrayList<Integer> distances) {

        ArrayList<Integer> divi = new ArrayList<>();

        for (int i : distances) {
            for (int j = 3; j <= i; j++) {
                if (i % j == 0) {
                    divi.add(j);
                }
            }
        }
        Collections.sort(divi);

        int oldDivi = divi.get(0);
        int counter = 0;
        int storeCount = 0;
        int storeValue = 0;

        for (int i = 0; i < divi.toArray().length; i++) {
            if (oldDivi == divi.get(i)) {
                counter++;
            } else {
                if (storeCount < counter) {
                    storeCount = counter;
                    storeValue = divi.get(i - 1);
                }
                counter = 0;
                oldDivi = divi.get(i);
            }
        }
        return storeValue;
    }

    public static String frequencyAnalysis(String wholeWord, int keyLength) {

        StringBuilder keyWord = new StringBuilder();

        for (int i = 0; i < keyLength; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < wholeWord.length() - i; j += keyLength) {
                word.append(wholeWord.charAt(j + i));
            }

            double[] wsk = helper.countChars(word.toString());
            char chr = findCaeserKey(wsk);
            keyWord.append(chr);
        }

        return keyWord.toString();

    }

    public static char findCaeserKey(double[] relFraqs) {

        double old = 500;
        int shift = 0;
        for (int key = 0; key < 26; key++) {
            double sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += Math.abs(relFraqs[(i + key) % 26] - GER[i]);
            }
            if (sum < old) {
                old = sum;
                shift = key;
            }

        }

        return (char) (shift + 65);
    }

}