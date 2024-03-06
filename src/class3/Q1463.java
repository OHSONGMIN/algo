package class3;

import java.util.Scanner;

public class Q1463 {
    public static Integer[] dp; //메모이제이션 할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    private static int recur(int N) {

        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 2), recur(N / 3))) + 1;
            }

            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }

            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }

            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
