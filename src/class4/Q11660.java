package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q11660 {
    static int[][] arr;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        dp[1][1] = arr[1][1];

        for (int i = 2; i < N+1; i++) {
            dp[1][i] = dp[1][i-1] + arr[1][i];
            dp[i][1] = dp[i-1][1] + arr[i][1];
        }

        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j < N+1; j++) {
                dp[i][j] = arr[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]);
        }


    }

    private static int find(int x1, int y1, int x2, int y2) {

//        if (x1 == 0 && y1 == 0) {
//            return dp[x2][y2] - dp[0][0];
//        }
//        else if (x1 == 0) {
//            return dp[x2][y2] - dp[x2][y1-1];
//        }
//        else if (y1 == 0) {
//            return dp[x2][y2] - dp[x1-1][y2];
//        }
//        else {
            return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];

    }
}
