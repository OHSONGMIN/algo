package class3;

import java.util.Scanner;

public class Q1074 { //시간 초과!!!
    static int[][] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int num = 1;
        for (int i = 0; i < N; i++) {
            num *= 2;
        }

        arr = new int[num][num];
        zRoute(N, 0, 0);

        System.out.println(arr[r][c]);
    }

    private static void zRoute(int n, int x, int y) {
        int zNum = 1;
        for (int i = 0; i < n; i++) {
            zNum *= 2;
        }

        if (n > 1) {
            zRoute(n-1, x, y);
            zRoute(n-1, x, y + zNum / 2);
            zRoute(n-1, x + zNum / 2, y);
            zRoute(n-1, x + zNum / 2, y + zNum / 2);
        } else { //n = 1
            arr[x][y] = count++;
            arr[x][y+1] = count++;
            arr[x+1][y] = count++;
            arr[x+1][y+1] = count++;
        }
    }
}
