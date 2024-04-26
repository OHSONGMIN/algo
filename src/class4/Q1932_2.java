package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932_2 {
    static int[][] arr;
    static Integer[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = arr[N - 1][i];
        }

        System.out.println(findDp(0, 0));
    }

    private static int findDp(int i, int j) {

        if (dp[0][0] != null) return dp[0][0];

        if (dp[i][j] == null) {

            dp[i][j] = arr[i][j] + Math.max(findDp(i + 1, j), findDp(i + 1, j + 1));
        }
        return dp[i][j];
    }
}
