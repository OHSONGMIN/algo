package class1;

import java.util.Scanner;

public class Q10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 1; i <= a; i++) {
            int num = sc.nextInt();

            if(num < b) {
                System.out.print(num + " ");
            }
        }
    }
}
