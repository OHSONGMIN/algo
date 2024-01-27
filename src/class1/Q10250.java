package class1;

import java.util.Scanner;

public class Q10250 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i = 1; i <= test; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            int n = sc.nextInt();

            int x = n / h;
            int y = n % h;
/* 수정 코드 */
            if (y == 0) {
                System.out.println(h * 100 + x);
            } else {
                System.out.println(y * 100 + x + 1);
            }
/* 원래 코드 */
/*
            if (x < 10) {
                System.out.println(y + "0" + x);
            } else {
                System.out.println(y + "" + x);
            }
*/
        }
    }
}
