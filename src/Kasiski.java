import java.util.*;
import java.util.stream.Collectors;

public class Kasiski {

    public static ArrayList<Integer> findRepeatedSequenceDistances(String s) {
        ArrayList<Integer> l = new ArrayList<>();

        for(int n = s.length()/2; n >= 4 ; n--) {
            for (int j = 0; j < s.length() - n + 1; j++) {
                String muster = s.substring(j, j + n);
                for (int i = j + 1; i < s.length(); i++) {
                    if (s.startsWith(muster, i)) {
                        int d = i - j;
                        if(!l.contains(d)) {
                            l.add(d);
                        }
                        //System.out.println(muster + ": " + d);
                    }
                }
            }
        }
        return l;
    }

    public static Integer determineMostLikelyKeyLength(ArrayList<Integer> num){

        ArrayList<Integer> divi = new ArrayList<>();

        for (int i : num){
            for(int j = 2; j <= i; j++){
                if(i % j == 0){
                    divi.add(j);
                }
            }
        }

        Collections.sort(divi);

        int count = 0;
        int temp = divi.get(0);

        int storeCount = 0;
        int storeValue = 0;

        for (int i = 0; i < divi.toArray().length; i++){
            if(temp == divi.get(i)){
                count++;
            }else{
                if (storeCount < count){
                    storeCount = count;
                    storeValue = divi.get(i-1);
                }
                count = 0;
                temp = divi.get(i);
            }
        }

        return storeValue;
    }

    public static void frequencyAnalysis(String wholeWord, int keyLenght, Hashtable<Character, Float> language){

        ArrayList<Hashtable<Character, Float>> out = new ArrayList<>();

        for (int i = 1; i <= keyLenght; i++){
            StringBuilder word = new StringBuilder();
            for (int j = 0; j <= wholeWord.length()-i; j += i){
                word.append(wholeWord.charAt(j));
            }
            //System.out.println();
            out.add(helper.countChars(word.toString()));
        }

        for(Hashtable<Character, Float> chars : out){

            chars.forEach( (k, v) -> {



            });

        }

    }

}
