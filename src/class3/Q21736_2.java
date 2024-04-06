package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21736_2 { //깊이우선탐색, 재귀함수
    static String[][] arr;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int count, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N][M];
        visit = new boolean[N][M];

        int pointX = 0;
        int pointY = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                String s = String.valueOf(str.charAt(j));
                arr[i][j] = s;

                if (s.equals("I")) {
                    pointX = i;
                    pointY = j;
                }
            }
        }

        count = 0;
        find(pointX, pointY);
        if (count == 0) System.out.println("TT");
        else System.out.println(count);
    }

    private static void find(int x, int y) {
        visit[x][y] = true;
        if (arr[x][y].equals("P")) count++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];

            if (newX >= 0 && newX < N && newY >= 0 && newY < M && !arr[newX][newY].equals("X") && !visit[newX][newY]) {
                find(newX, newY);
            }
        }

    }
}
