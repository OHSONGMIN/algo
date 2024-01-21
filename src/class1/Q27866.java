package class1;

import java.util.Scanner;

public class Q27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int num = scanner.nextInt();

        char ch = str.charAt(num-1);
        System.out.println(ch);
    }
}
