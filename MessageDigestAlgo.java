import java.security.*;
import java.util.Scanner;

public class MessageDigestAlgo {
    public static void main(String[] a) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter a string (q to quit): ");
                String input = scanner.nextLine();
                if (input.equals("q")) break;
                md.update(input.getBytes());
                byte[] output = md.digest();
                System.out.println("MD5(\"" + input + "\") = " + bytesToHex(output));
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static String bytesToHex(byte[] b) {
        char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }
}
