package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500_3 {
    static int N, M, max;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true; //방문함
                dfs(1, i, j, arr[i][j]);
                visit[i][j] = false; //해당 재귀 종료 후 미방문 처리

                other(i, j);
            }
        }
        System.out.println(max);
    }

    private static void other(int i, int j) {
        if (i+2 < N && j+1 < M) { // ㅏ 모양
            max = Math.max(max, arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1]);
        }
        if (i+2 < N && j+1 < M) { // ㅓ 모양
            max = Math.max(max, arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1] + arr[i+1][j]);
        }
        if (i+1 < N && j+2 < M) { // ㅗ 모양
            max = Math.max(max, arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2]);
        }
        if (i+1 < N && j+2 < M) { // ㅜ 모양
            max = Math.max(max, arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1]);
        }
    }

    private static void dfs(int count, int r, int c, int sum) {

        if (count == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newR = r + dirX[i];
            int newC = c + dirY[i];

            if (newR < 0 || newR >= N || newC < 0 || newC >= M) continue;
            if (visit[newR][newC]) continue;

            visit[newR][newC] = true;
            dfs(count + 1, newR, newC, sum + arr[newR][newC]);
            visit[newR][newC] = false;
        }
    }
}

