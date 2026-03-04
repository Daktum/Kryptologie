import java.util.ArrayList;
import java.util.Collections;

public class Kasiski {

    public static final double[] REL_H_ENGLISCH = {8.17, 1.49, 2.78, 4.25, 12.70, 2.23, 2.02, 6.09, 6.97, 0.15, 0.78, 4.03, 2.41, 6.75, 7.51, 1.93, 0.10, 5.99, 6.33, 9.06, 2.76, 0.98, 2.36, 0.15, 1.97, 0.07};
    public static final double[] REL_H_DEUTSCH = {6.51, 1.89, 3.06, 5.08, 17.40, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7.00, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13};
    public static final double[] REL_H_FRANZOESISCH = {7.63, 0.90, 3.26, 3.66, 14.72, 1.07, 0.87, 0.74, 7.53, 0.55, 0.05, 5.45, 2.97, 7.09, 5.38, 3.02, 1.36, 6.55, 7.95, 7.23, 6.31, 1.63, 0.11, 0.39, 0.31, 0.14};


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

            double[] wsk = helper.berechneRelativeHaeufigkeiten(word.toString());
            char chr = bestimmeBestenCaesarSchluessel(wsk, REL_H_DEUTSCH);
            keyWord.append(chr);
        }

        return keyWord.toString();

    }

    public static char bestimmeBestenCaesarSchluessel(double[] relH, double[] relHSprache) {
        int besterSchluessel = 0;
        double kleinsteAbweichung = Double.POSITIVE_INFINITY;
        for (int schluessel = 0; schluessel < 26; schluessel++) {
            double abweichung = 0;
            for (int i = 0; i < 26; i++) {
                abweichung += Math.abs(relH[(i + schluessel) % 26] - relHSprache[i]);
            }
            if (abweichung < kleinsteAbweichung) {
                kleinsteAbweichung = abweichung;
                besterSchluessel = schluessel;
            }
        }
        return (char) ('A' + besterSchluessel);
    }

}



