package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149_2 { //dp 메모이제이션 // top-down
    static int[][] dp;
    static int[][] arr;
    static int N;
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][3];
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][Red] = arr[0][Red];
        dp[0][Green] = arr[0][Green];
        dp[0][Blue] = arr[0][Blue];

        //배열은 0부터 시작하니까 N-1
        System.out.println(Math.min(find(N-1, Red), Math.min(find(N-1, Green), find(N-1, Blue))));
    }

    private static int find(int N, int color) {

        if (dp[N][color] == 0) {

            //color
            if (color == Red) {
                dp[N][color] = arr[N][Red] + Math.min(find(N-1, Green), find(N-1, Blue));
            }
            else if (color == Green) {
                dp[N][color] = arr[N][Green] + Math.min(find(N-1, Red), find(N-1, Blue));
            }
            else { //color == Blue
                dp[N][color] = arr[N][Blue] + Math.min(find(N-1, Red), find(N-1, Green));
            }
        }

        return dp[N][color];
    }
}
