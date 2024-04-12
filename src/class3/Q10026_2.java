package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026_2 { //dfs 에서드 하나만 만들어서 해보기
    static int N;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        //정상일 경우
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visit[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        int normal_cnt = cnt;

        //색맹일 경우
        cnt = 0;
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') arr[i][j] = 'R';

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visit[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        int abnormal_cnt = cnt;

        System.out.println(normal_cnt + " " + abnormal_cnt);
    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dirX[k];
            int y = j + dirY[k];

            if (x >= 0 && x < N && y >= 0 && y < N) {
                if (arr[i][j] == arr[x][y] && !visit[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
