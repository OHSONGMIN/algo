package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 { //왜틀림?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N];
            int[][] dp = new int[2][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[1][j] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[0][0];

            if (N == 1) {
                int max = Math.max(dp[0][N-1], dp[1][N-1]);
                System.out.println(max);
            }
            else {
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[1][1] + arr[0][0];

                for (int j = 2; j < N; j++) {
                    dp[0][j] = arr[0][j] + Math.max(dp[1][j - 1], dp[1][j - 2]);
                    dp[1][j] = arr[1][j] + Math.max(dp[0][j - 1], dp[0][j - 2]);
                }
                int max = Math.max(dp[0][N - 1], dp[1][N - 1]);
                System.out.println(max);
            }
        }
    }
}
