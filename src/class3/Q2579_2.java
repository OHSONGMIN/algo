package class3;

import java.util.Scanner;

public class Q2579_2 {
    public static int[] arr;
    public static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        //N이 1이 아닐 경우
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
        }

        System.out.println(dp[N]);
    }
}
