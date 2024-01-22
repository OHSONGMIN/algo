package class1;

import java.util.Scanner;

public class Q10039 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for (int i = 1; i <= 5; i++) {
            int num = sc.nextInt();

            if (num < 40) {
                num = 40;
            }

            sum += num;
        }

        System.out.println(sum/5);
    }
}
