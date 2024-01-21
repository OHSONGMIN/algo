package class1;

import java.util.Scanner;

public class Q10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());

        int max = 1;
        int min = 1000000;

        for (int i = 1; i <= 5; i++) {
            int input = sc.nextInt();

            if (input > max) {
                max = input;
            }
            if (input < min) {
                min = input;
            }
        }

        System.out.println(min + " " + max);
    }
}
