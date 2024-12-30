package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17144_3 {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static int R, C, T;
    static int[][] arr;
    static int cleaner = -1; // 공기청정기 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (cleaner == -1 && arr[i][j] == -1) {
                    cleaner = i;
                }
            }
        }
        while (T-- > 0) {
            diffuse();
            clean();
        }

        calculate();
    }

    // 먼지 확산
    private static void diffuse() {
        // 먼지가 있으면 Queue에 담는다 (행, 열, 값)
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (arr[i][j] > 0) {
                    q.add(new Node(i, j, arr[i][j]));
                }
            }
        }

        // 먼지 확산 - Queue에 담긴 값을 이용
        while (!q.isEmpty()) {

            Node node = q.poll();

            int cnt = 0; // 확산된 수
            int dust = node.z / 5; // 확산되는 양

            for (int k = 0; k < 4; k++) {
                int newX = node.x + dirX[k];
                int newY = node.y + dirY[k];

                if (newX >= 0 && newX < R && newY >= 0 && newY < C && arr[newX][newY] != -1) {
                    arr[newX][newY] += dust;
                    cnt++;
                }
            }
            arr[node.x][node.y] -= dust * cnt;
        }
    }

    private static void clean() {
        // 위쪽 공기청정기
        int top = cleaner;

        // 위에서 아래로 당기기
        for (int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        // 오른쪽에서 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        // 아래에서 위로 당기기
        for (int i = 0; i < top; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }
        // 왼쪽에서 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            arr[top][i] = arr[top][i - 1];
        }
        // 공기청정기에서 나온 공기는 0
        arr[top][1] = 0;

        // 아래쪽 공기청정기
        int bottom = cleaner + 1;

        // 아래에서 위로 당기기
        for (int i = bottom + 1; i < R - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        // 오른쪽에서 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
        // 위에서 아래로 당기기
        for (int i = R - 1; i > bottom; i--) {
            arr[i][C - 1] = arr[i - 1][C - 1];
        }
        // 왼쪽에서 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            arr[bottom][i] = arr[bottom][i - 1];
        }

        // 공기청정기에서 나온 공기는 0
        arr[bottom][1] = 0;

    }

    private static void calculate() {
        int total = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) {
                    total += arr[i][j];
                }
            }
        }

        System.out.println(total);
    }


    private static class Node {

        int x;
        int y;
        int z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
