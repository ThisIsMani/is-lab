import java.util.*;
public class TranspositionCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpuString = scanner.nextLine();
        String key = scanner.nextLine();
        int[] keyArray = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyArray[i] = Integer.valueOf(key.substring(i, i + 1)) - 1;
        }
        int columnLength = key.length();
        int rowLength = (inpuString.length() + columnLength) / columnLength;
        System.out.println(rowLength + " " + columnLength + " " + inpuString.length());
        char[][] cipherText = new char[rowLength][columnLength];
        for (int i = 0; i < inpuString.length(); i++) {
            cipherText[i / columnLength][keyArray[(i) % columnLength]] = inpuString.charAt(i);
        }
        String encryptedMessage = "";
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                encryptedMessage += cipherText[j][i];
            }
        }
        System.out.println(Arrays.deepToString(cipherText));
        System.out.println("Encrypted Message is: " + encryptedMessage);
        char[][] original = new char[rowLength][columnLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                original[i][j] = cipherText[i][keyArray[j]];
            }
        }
        String decryptedMessage = "";
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                decryptedMessage += original[i][j];
            }
        }
        System.out.println(Arrays.deepToString(original));
        System.out.println("Decrypted Message is: " + decryptedMessage);
        scanner.close();
    }
}
