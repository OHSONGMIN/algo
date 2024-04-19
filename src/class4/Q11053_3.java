package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053_3 { //top - down
    static int[] arr;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            lis(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int lis(int i) {

        if (dp[i] == 0) {
            dp[i] = 1; //최소 수열의 길이는 1

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], lis(j) + 1);
                }
            }
        }

        return dp[i];
    }
}
