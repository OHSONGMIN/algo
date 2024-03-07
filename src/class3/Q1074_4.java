package class3;

import java.util.Scanner;

public class Q1074_4 {
    static int count = 0;
    static int size = 0;
    static int r;
    static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        size = (int) Math.pow(2, N); //2의 제곱 구하는 방법!

        zRoute(size, 0, 0);
    }

    private static void zRoute(int size, int x, int y) {
        if (size == 1) { //size가 1 일 때
            System.out.println(count);
            return;
        }

        //size가 1 초과일 때
        int newSize = size / 2;
        if (r < x + newSize && c < y + newSize) {
            //1사분면
            zRoute(newSize, x, y);
        }
        else if (r < x + newSize && c >= y + newSize) {
            //2사분면
            count += (size * size) / 4;
            zRoute(newSize, x, y + newSize);
        }
        else if (r >= x + newSize && c < y + newSize) {
            //3사분면
            count += (size * size) / 4 * 2;
            zRoute(newSize, x + newSize, y);
        }
        else if (r >= x + newSize && c >= y + newSize) {
            //4사분면
            count += (size * size) / 4 * 3;
            zRoute(newSize, x + newSize, y + newSize);
        }
    }
}
