package class1;

import java.util.Scanner;

public class Q10951 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();

            String[] strs = str.split("\\s");

            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);

            System.out.println(a+b);
        }
    }
}

