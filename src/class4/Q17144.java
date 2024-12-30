package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144 {

    static int N, M, T, s1, s2, dust;
    static int[][] arr, copyArr;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];

        // 0으로 채우기
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(arr[i], 0);
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < M + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == -1) {
                    s2 = i;
                }
            }
        }
        s1 = s2 - 1; // 공기청정기 위치

        for (int i = 0; i < T; i++) {
            // 미세먼지 확산
            diffuseDust(arr);

            // 공기청정기 순환
            cleanAir(arr);
        }

        // 미세먼지 양 구하기
        cntDust(arr);
        System.out.println(dust);
    }

    private static void diffuseDust(int[][] arr) {
        Queue<Node> q = new LinkedList<>();

        copyArr = new int[N + 1][M + 1];
        copyArr = arr.clone();

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {

                // 4 이하은 확산되지 않음 0, -1도 확산되지 않음
                if (copyArr[i][j] > 4) {

                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int newX = i + dirX[k];
                        int newY = j + dirY[k];

                        if (newX > 0 && newX < N + 1 && newY > 0 && newY < M + 1) {
                            if (copyArr[newX][newY] != -1) {
                                arr[newX][newY] += copyArr[i][j] / 5;
                                cnt++;
                            }
                        }
                        arr[i][j] = arr[i][j] - arr[i][j] / 5 * cnt;
                    }
                }
            }
        }
    }

    private static void cleanAir(int[][] arr) {
        int temp = arr[s1][M]; //맨 끝 값

        for (int i = M; i > 2; i--) {

            arr[s1][i] = arr[s1][i-1];
        }
        arr[s1][2] = 0; // 공기청정기에서 나온 값 0

        int temp2 = arr[1][M];

        for (int i = 1; i < s1 - 1; i++) {

            arr[i][M] = arr[i+1][M];
        }

        arr[s1-1][M] = temp; //이게 왜 오류?

        temp = arr[1][1];

        for (int i = 1; i < M - 1; i++) {

            arr[1][i] = arr[1][i+1];
        }

        arr[1][M-1] = temp2;

        for (int i = s1 - 1; i > 2; i--) {
            arr[i][1] = arr[i-1][1];
        }

        arr[2][1] = temp;

        // 아래 공기청정기
        temp = arr[s2][M]; //맨 끝 값

        for (int i = M; i > 2; i--) {

            arr[s2][i] = arr[s2][i-1];
        }
        arr[s2][2] = 0; // 공기청정기에서 나온 값 0

        temp2 = arr[N][M];

        for (int i = N; i > s2; i--) {

            arr[i][M] = arr[i-1][M];
        }

        arr[s2+1][M] = temp;

        temp = arr[N][1];

        for (int i = 1; i < M - 1; i++) {

            arr[N][i] = arr[N][i+1];
        }

        arr[N][M-1] = temp2;

        for (int i = s2 + 1; i < N; i++) {
            arr[i][1] = arr[i+1][1];
        }

        arr[N][1] = temp;
    }

    private static void cntDust(int[][] arr) {
        dust = 0;

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {

                if (arr[i][j] != 0 && arr[i][j] != -1) {
                    dust += arr[i][j];
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



