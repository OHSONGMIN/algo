package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144_2 {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int R, C, T, s1, s2, lastCnt; //행, 열, 횟수
    static int[][] arr, copyArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R + 1][C + 1];
        copyArr = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < R; i++) {
            if (arr[i][1] == -1) {
                s1 = i;
                break;
            }
        }
        s2 = s1 + 1;

        for (int i = 0; i < T; i++) {
            // 확산
            spreadDust(arr);

            // 공기청정기
            cleanAir(arr);

        }

        // 남은 먼지 계싼
        accountDust(arr);

        System.out.println(lastCnt);
    }

    private static void accountDust(int[][] arr) {
        lastCnt = 0;

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {

                if (arr[i][j] > 0) {
                    lastCnt += arr[i][j];
                }
            }
        }
    }

    private static void cleanAir(int[][] arr) {
        // 위쪽 공기청정기
        // 위에서 아래로
        for (int i = s1 - 1; i >= 2; i--) {
            arr[i][1] = arr[i - 1][1];
        }

        // 오른쪽에서 왼쪽으로
        for (int i = 1; i < C; i++) {
            arr[1][i] = arr[1][i + 1];
        }

        // 아래에서 위로
        for (int i = 1; i < s1; i++) {
            arr[i][C] = arr[i + 1][C];
        }

        // 왼쪽에서 오른쪽으로
        for (int i = C; i > 2; i--) {
            arr[s1][i] = arr[s1][i - 1];
        }

        arr[s1][2] = 0;

        // 아래쪽 공기청정기
        // 아래에서 위로
        for (int i = s2 + 1; i < R; i++) {
            arr[i][1] = arr[i + 1][1];
        }

        // 오른쪽에서 왼쪽으로
        for (int i = 1; i < C; i++) {
            arr[R][i] = arr[R][i + 1];
        }

        // 위에서 아래로
        for (int i = R; i > s2; i--) {
            arr[i][C] = arr[i - 1][C];
        }

        // 왼쪽에서 오른쪽으로
        for (int i = C; i > 2; i--) {
            arr[s2][i] = arr[s2][i - 1];
        }

        arr[s2][2] = 0;
    }

    private static void spreadDust(int[][] arr) {
        // 배열 복사 후
        for (int i = 1; i <= R; i++) {
            copyArr[i] = arr[i].clone();
        }

        // copyArr 먼지 양 계산하고 원본 배열에 합산
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {

                if (copyArr[i][j] > 0) {

                    int cnt = 0;
                    int dust = copyArr[i][j] / 5;

                    for (int k = 0; k < 4; k++) {
                        int newI = i + dirX[k];
                        int newJ = j + dirY[k];

                        if (newI > 0 && newI <= R && newJ > 0 && newJ <= C && arr[newI][newJ] != -1) {

                            arr[newI][newJ] += dust;
                            cnt++;
                        }
                    }

                    arr[i][j] -= dust * cnt;
                }
            }
        }
    }
}
