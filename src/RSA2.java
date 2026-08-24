import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA2 {
    private String name;

    private BigInteger p;
    private BigInteger q;

    private BigInteger n;
    private BigInteger phi;

    private BigInteger e;
    private BigInteger d;

    private SecureRandom random;

    public RSA2(int bitLength, String name) {
        random = new SecureRandom();

        // Generate two prime numbers
        p = BigInteger.probablePrime(bitLength, random);
        q = BigInteger.probablePrime(bitLength, random);

        // Calculate modulus
        n = p.multiply(q);

        // Calculate Euler's phi function
        phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        // Generate public exponent
        e = generatePublicKey();

        // Calculate private exponent
        d = calculatePrivateKey();
    }

    private BigInteger generatePublicKey() {
        BigInteger e;

        do {
            e = new BigInteger(phi.bitLength(), random);
            e = e.setBit(0);
        } while (e.compareTo(BigInteger.ONE) <= 0
                || e.compareTo(phi) >= 0
                || !e.gcd(phi).equals(BigInteger.ONE));

        return e;
    }

    private BigInteger calculatePrivateKey() {
        return e.modInverse(phi);
    }

    public BigInteger getE() { return e; }
    public BigInteger getD() { return d; }
    public BigInteger getN() { return n; }
}