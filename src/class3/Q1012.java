package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 { //깊이우선탐색(DFS) - 재귀함수
    public static boolean[][] arr;
    public static int M;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); //가로 길이
            N = Integer.parseInt(st.nextToken()); //세로 길이
            int K = Integer.parseInt(st.nextToken()); //배추

            arr = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            int count = 0;

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == true) {
                        cabbage(j, k, arr);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }

    }

    private static void cabbage(int j, int k, boolean[][] arr) {
        arr[j][k] = false;

        if (j > 0 && arr[j-1][k] == true) cabbage(j-1, k, arr);
        if (k > 0 && arr[j][k-1] == true) cabbage(j, k-1, arr);
        if (j < M - 1 && arr[j+1][k] == true) cabbage(j+1, k, arr);
        if (k < N - 1 && arr[j][k+1] == true) cabbage(j, k+1, arr);
    }
}
