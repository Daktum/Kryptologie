import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String word = "TARNUNGAUFGEFLOGENSTOPBINENTDECKTSTOPFLUCHTNACHDAENEMARK";

        // 5 und 3 kommt nichts sinnvolles herraus

        word = helper.makeUsebleString(word);

        String outWord = Skytale.encrypt(word, 8);

        System.out.println("Out Word: " + outWord);
    }

}