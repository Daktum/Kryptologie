public class Kolonne {


    public static String encrypt(String text, String key) {

        StringBuilder textBuilder = new StringBuilder(text);
        while(textBuilder.length() % 9 != 0) {
            textBuilder.append('X');
        }
        text = textBuilder.toString();

        text = text.replaceAll(" ", "");
        text = text.toUpperCase();


        String s = text.substring(0, 9);

        System.out.println(s);


        return "";
    }

}
