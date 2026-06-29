public class Kolonne {

    public static String encrypt(String plain, String password) {
        String secret = "";

        while (plain.length() % 9 != 0) {
            plain += 'X';
        }

        for (int i = 0; i < password.charAt(0); i++) {
            plain = rotate(plain);
        }

        for (int i = 0; i < 9; i++) {
            secret += Caesar.encryptChar(plain.charAt(i), password.charAt(i + 1));
        }

        return secret;
    }

    public static String decrypt(String secret, String password) {
        String plain = "";

        for (int i = 0; i < 9; i++) {

            int k = password.charAt(i + 1) - '0';

            plain += Caesar.decryptChar(secret.charAt(i), k);
        }

        int rotations = password.charAt(0) - '0';
        rotations = 8 - rotations;

        for (int i = 0; i < rotations; i++) {
            plain = rotate(plain);
        }

        return plain;
    }


    private static String rotate(String text) {
        String rotated = "";

        rotated += text.charAt(1);
        rotated += text.charAt(2);
        rotated += text.charAt(5);
        rotated += text.charAt(0);
        rotated += text.charAt(4);
        rotated += text.charAt(8);
        rotated += text.charAt(3);
        rotated += text.charAt(6);
        rotated += text.charAt(7);

        return rotated;
    }

}