package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14940 {
    public static int[][] arr;
    public static boolean[][] visit;
    public static int[][] result;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; //원본 배열
        visit = new boolean[N][M]; //방문했었는지
        result = new int[N][M]; //최종 결좌

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result[0][0] = 0;
        visit[0][0] = true;

        countDistance(0, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void countDistance(int i, int j) {
        int plusResult = result[i][j] + 1;
        visit[i][j] = true;

        if (j-1 >= 0 && j+1 < M) {
            if (arr[i][j - 1] != 0 && visit[i][j - 1] == false) {
                result[i][j - 1] = plusResult;
                countDistance(i, j - 1);
            }
            if (arr[i][j + 1] != 0 && visit[i][j + 1] == false) {
                result[i][j + 1] = plusResult;
                countDistance(i, j + 1);
            }
        }

        if (i-1 >= 0 && i+1 < N) {
            if (arr[i - 1][j] != 0 && visit[i - 1][j] == false) {
                result[i - 1][j] = plusResult;
                countDistance(i - 1, j);
            }
            if (arr[i + 1][j] != 0 && visit[i + 1][j] == false) {
                result[i + 1][j] = plusResult;
                countDistance(i + 1, j);
            }
        }

    }
}
