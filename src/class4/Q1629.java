package class4;

import java.util.Scanner;

public class Q1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int result = A;

        for (int i = 0; i < B; i++) {
            result = ((result % C) * (A % C)) % C;
        }

        System.out.println(result);
    }
}
