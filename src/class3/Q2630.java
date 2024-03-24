package class3;

import java.util.Scanner;

public class Q2630 {
    public static int[][] arr;
    public static int N;
    public static int blue;
    public static int white;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        countConfetti(0, 0);
    }

    private static void countConfetti(int i, int j) {
        if (arr[i][j] == arr[i][j+1]) 
    }


}
