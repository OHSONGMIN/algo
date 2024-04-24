package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 { //시간 초과
    static int[][] arr;
    static int N, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        dfs(0, -1, 0);
        System.out.println(min);
    }

    private static void dfs(int depth, int before, int sum) {

        if (depth == N) {
            min = Math.min(min, sum);
        }
        else {

            for (int i = 0; i < 3; i++) {

                if (i == before) continue;
                else {
                    dfs(depth + 1, i, sum + arr[depth][i]);
                }
            }
        }
    }
}
