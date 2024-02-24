package class2;

import java.util.Scanner;

public class Q2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        while (true) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                break;
            }

            N = N - 3;
            cnt++;

            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }
/*
        int count = 100000;

        for (int i = 0; i <= N/5; i++) {
            for (int j = 0; j <= N/3; j++) {
                if ((5 * i + 3 * j) == N && (i + j) < count) {
                    count = (i + j);
                }
            }
        }
        if (count == 100000) System.out.println(-1);
        else System.out.println(count);

 */
    }
}
