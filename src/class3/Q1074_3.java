package class3;

import java.util.Scanner;

public class Q1074_3 { //틀림 왜??????????
    static long N;
    static long r;
    static long c;
    static long cntStart;
    static long cntEnd;
    static long xStart = 0;
    static long xEnd;
    static long yStart = 0;
    static long yEnd;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        cntStart = 0;
        cntEnd = 1;
        for (int i = 0; i < N; i++) {
            cntEnd *= 2;
        }
        xEnd = cntEnd;
        yEnd = cntEnd;
        cntEnd *= cntEnd;

        zRoute(N);
    }

    private static void zRoute(long n) {
        if (n > 1) {
            if (xStart <= r && r < xStart + (xEnd - xStart)/2) {
                if (yStart <= c && c <yStart + (yEnd - yStart)/2) {
                    xEnd = xStart + (xEnd - xStart) / 2;
                    yEnd = yStart + (yEnd - yStart) / 2;
                    cntEnd = cntStart + (cntEnd - cntStart) / 4;
                    zRoute(n-1);
                }
                else {
                    xEnd = xStart + (xEnd - xStart) / 2;
                    yStart = yStart + (yEnd - yStart) / 2;
                    cntStart = cntStart + (cntEnd - cntStart) / 4;
                    cntEnd = cntStart + (cntEnd - cntStart) / 4 * 2;
                    zRoute(n-1);
                }
            } else {
                if (yStart <= c && c <yStart + (yEnd - yStart)/2) {
                    xStart = xStart + (xEnd - xStart) / 2;
                    yEnd = yStart + (yEnd - yStart) / 2;
                    cntStart = cntStart + (cntEnd - cntStart) / 4 * 2;
                    cntEnd = cntStart + (cntEnd - cntStart) / 4 * 3;
                    zRoute(n-1);
                }
                else {
                    xStart = xStart + (xEnd - xStart) / 2;
                    yStart = yStart + (yEnd - yStart) / 2;
                    cntStart = cntStart + (cntEnd - cntStart) / 4 * 3;
                    zRoute(n-1);
                }
            }
        } else { //n = 1
            if (r % 2 == 0) {
                if (c % 2 == 0) {
                    System.out.println(cntStart);
                }
                else {
                    System.out.println(cntStart + 1);
                }
            } else {
                if (c % 2 == 0) {
                    System.out.println(cntStart + 2);
                }
                else {
                    System.out.println(cntStart + 3);
                }
            }
        }
    }
}
