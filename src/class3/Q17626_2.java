package class3;

import java.util.Scanner;

public class Q17626_2 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        solve(n);

        System.out.println(dp[n]);
    }

    private static void solve(int n) {
        for (int i = 1; i <= n; i++) { //1 ~ n까지
            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) { //j의 제곱이 i를 넘지 않을 때까지
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }
    }
}
