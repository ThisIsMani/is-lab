import java.util.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.*;
import java.security.SecureRandom;

public class DataEncryptionStandard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte[] raw;
        try {
            Random random = new Random();
            KeyGenerator kgen = KeyGenerator.getInstance("DES");
            SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
            sr.setSeed(String.valueOf(random.nextInt(10000)).getBytes());
            kgen.init(56, sr);
            raw = kgen.generateKey().getEncoded();
            System.out.println("DES Symmetric key is " + new String(raw));

            String input = scanner.nextLine();
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "DES");
            Cipher cipher;
            cipher = Cipher.getInstance("DES");

            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedMessage = cipher.doFinal(input.getBytes());
            System.out.println("Encrypted message is : " + new String(encryptedMessage));

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            System.out.println("Decrypted message is: " + new String(cipher.doFinal(encryptedMessage)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}

