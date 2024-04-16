package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    static int N, M, max;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(i, j);
            }
        }
        System.out.println(max);
    }

    private static void find(int i, int j) {

        if (i+3 < N) { // 긴 테트리스1
            int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
            max = Math.max(sum, max);
        }

        if (j+3 < M) { // 긴 테트리스2
            int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
            max = Math.max(sum, max);
        }

        if (i+1 < N && j+1 < M) { //네모 테트리스
            int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
            max = Math.max(sum, max);
        }
        // 니은 자 테트리스1
        if (i+2 < N && j+1 < M) {
            int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
            max = Math.max(sum, max);

            sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
            max = Math.max(sum, max);

            sum = arr[i+2][j] + arr[i+2][j+1] + arr[i+1][j+1] + arr[i][j+1];
            max = Math.max(sum, max);

            sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];
            max = Math.max(sum, max);
        }
        // 니은 자 테트리스2
        if (i+1 < N && j+2 < M) {
            int sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j+2];
            max = Math.max(sum, max);

            sum = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+2];
            max = Math.max(sum, max);

            sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
            max = Math.max(sum, max);

            sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
            max = Math.max(sum, max);
        }
        //번개 모양 테트리스1
        if (i+2 < N && j+1 < M) {
            int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
            max = Math.max(sum, max);

            sum = arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j] + arr[i+2][j];
            max = Math.max(sum, max);
        }
        //번개 모양 테트리스2
        if (i+1 < N && j+2 < M) {
            int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
            max = Math.max(sum, max);

            sum = arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1] + arr[i][j+2];
            max = Math.max(sum, max);
        }
        //ㅗ자 테트리스1
        if (i+1 < N && j+2 < M) {
            int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
            max = Math.max(sum, max);

            sum = arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2] + arr[i][j+1];
            max = Math.max(sum, max);
        }
        //ㅗ자 테트리스2
        if (i+2 < N && j+1 < M) {
            int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
            max = Math.max(sum, max);

            sum = arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
            max = Math.max(sum, max);
        }
    }
}
