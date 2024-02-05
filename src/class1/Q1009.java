package class1;

import java.util.Scanner;

public class Q1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int result = a % 10;

            for (int j = 1; j < b; j++) {
                result = (result * a) % 10;
            }
            if (result == 0) result = 10;

            System.out.println(result);
        }
    }
}
