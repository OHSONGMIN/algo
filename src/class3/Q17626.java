package class3;

import java.util.Scanner;

public class Q17626 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[50001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        for (int i = 3; i < 224; i++) {
            dp[i * i] = 1;
        }

        if (dp[n] != 0) System.out.println(dp[n]);
        else {
            System.out.println(find(n));
        }
    }

    private static int find(int n) {
        for (int i = 223; i > 0; i--) {
            if (n - i * i < 0) continue;

            int k = n - i * i; //제곱 후 나머지 값
            if (dp[k] == 0) dp[k] = find(k);

            if (dp[k] < 4 && dp[n] == 0) {
                dp[n] = dp[k] + 1;
            }
            if (dp[k] < 4 && dp[n] > dp[k] + 1) {
                dp[n] = dp[k] + 1;
            }

        }
        return dp[n];
    }
}
