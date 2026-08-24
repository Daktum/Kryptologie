import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RSA2Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        RSA2 alice = new RSA2(128, "Alice");
        RSA2 bob   = new RSA2(128, "Bob");

        System.out.println();
        System.out.println("Alice public key:");
        System.out.println("e = " + alice.getE());
        System.out.println("n = " + alice.getN());

        System.out.println();
        System.out.println("Bob public key:");
        System.out.println("e = " + bob.getE());
        System.out.println("n = " + bob.getN());

        String plain = "HELLO_WORLD";

        System.out.println();
        System.out.println("Original message:");
        System.out.println(plain);

        // Alice encrypts the message for Bob.
        BigInteger message = strToBigInt(plain);
        BigInteger cipher = message.modPow(bob.getE(), bob.getN());

        // Calculate a cryptographic hash over the data to be signed.
        // Here Alice signs the encrypted message (the ciphertext).
        byte[] messageBytes = cipher.toByteArray();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(messageBytes);
        BigInteger hash = new BigInteger(1, hashBytes);

        // Simplified textbook RSA signature with Alice's private key:
        // s = h^d mod n
        BigInteger signature = hash.mod(alice.getN())
                .modPow(alice.getD(), alice.getN());

        System.out.println();
        System.out.println("Alice encrypts message for Bob:");
        System.out.println(cipher);

        System.out.println();
        System.out.println("SHA-256 hash of the ciphertext:");
        System.out.println(hash.toString(16));

        System.out.println();
        System.out.println("Alice's signature:");
        System.out.println(signature);

        // Bob verifies the signature with Alice's public key.
        // Verify with Alice's public key: h'' = s^e mod n
        BigInteger verifiedHash = signature.modPow(
                alice.getE(),
                alice.getN()
        );
        boolean signatureValid = verifiedHash.equals(hash.mod(alice.getN()));

        System.out.println();
        System.out.println("Signature valid: " + signatureValid);

        // Bob decrypts the message.
        // Decrypt with Bob's private key: m = c^d mod n
        BigInteger decrypted = cipher.modPow(bob.getD(), bob.getN());

        System.out.println();
        System.out.println("Bob decrypts the message:");
        System.out.println(bigIntToStr(decrypted));
    }

    private static BigInteger strToBigInt(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text must not be null or empty.");
        }

        StringBuilder encodedDigits = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character == '_') {
                encodedDigits.append("00");
            } else {
                if (character < 'A' || character > 'Z') {
                    throw new IllegalArgumentException(
                            "Only the characters A-Z and _ are supported: " + character
                    );
                }

                int pos = character - 'A' + 1;
                if (pos < 10) {
                    encodedDigits.append('0');
                }
                encodedDigits.append(pos);
            }
        }

        return new BigInteger(encodedDigits.toString());
    }

    private static String bigIntToStr(BigInteger number) {
        if (number == null || number.signum() < 0) {
            throw new IllegalArgumentException("Number must be non-null and non-negative.");
        }

        String encodedDigits = number.toString();

        if (encodedDigits.length() % 2 != 0) {
            encodedDigits = "0" + encodedDigits;
        }

        StringBuilder decodedText = new StringBuilder();

        for (int i = 0; i < encodedDigits.length(); i += 2) {
            int pos = Integer.parseInt(
                encodedDigits.substring(i, i + 2)
            );

            if (pos == 0) {
                decodedText.append('_');
            } else if (pos >= 1 && pos <= 26) {
                decodedText.append((char) ('A' + pos - 1));
            } else {
                throw new IllegalArgumentException(
                        "Invalid encoded character value: " + pos
                );
            }
        }

        return decodedText.toString();
    }
}