package class3;

import java.util.Scanner;

public class Q11727 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        if (n > 2) System.out.println(find(n));
        else System.out.println(dp[n]);
    }

    private static int find(int n) {
        if (dp[n] != 0) return dp[n];

        dp[n] = (find(n-1) + find(n-2) * 2) % 10007;
        return dp[n];
    }
}
