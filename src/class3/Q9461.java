package class3;

import java.util.Scanner;

public class Q9461 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            if (N > 5) sb.append(find(N)).append("\n");
            else sb.append(dp[N]).append("\n");
        }

        System.out.println(sb);
    }

    private static long find(int n) {
        if (dp[n] != 0) return dp[n];

        dp[n] = find(n-1) + find(n-5);
        return dp[n];
    }
}
