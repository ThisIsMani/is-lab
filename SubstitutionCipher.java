import java.util.*;

public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String res = "";
        for (int i = 0; i < input.length(); i++) {
            res += (char) ((122 - input.codePointAt(i)) + 97);
        }
        System.out.println(res);
        scanner.close();
    }
}