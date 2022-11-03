import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to be encrypted and decrypted: ");
        int msg = scanner.nextInt();
        System.out.print("Enter 1st prime number p: ");
        int p = scanner.nextInt();
        System.out.print("Enter 2nd prime number q: ");
        int q = scanner.nextInt();
        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("The value of z = " + z);
        int e, d = 0;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1)
                break;
        }
        System.out.println("The value of e = " + e);
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d = " + d);
        double c = Math.pow(msg, e) % n;
        System.out.println("Encrypted message is : " + c);
        BigInteger msgback = (BigDecimal.valueOf(c).toBigInteger().pow(d)).mod(BigInteger.valueOf(n));
        System.out.println("Derypted message is : " + msgback);

    }

    static int gcd(int e, int z) {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}