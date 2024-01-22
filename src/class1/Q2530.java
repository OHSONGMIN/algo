package class1;

import java.util.Scanner;

public class Q2530 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        int c = sc.nextInt();
/*
        if ((s + c) >= 60) {
            m += ((s + c) / 60);
            s = (s + c) % 60;
        }

        if (m >= 60) {
            h += (m / 60);
            m %= 60;
        }

        if (h >= 24) {
            h %= 24;
        }
*/

        int num = h * 3600 + m * 60 + s + c;

        num %= 86400;

        h = num / 3600;
        m = (num % 3600) / 60;
        s = (num % 3600) % 60;

        System.out.println(h + " " + m + " " + s);

    }
}
