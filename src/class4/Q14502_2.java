package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502_2 {

    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] originalMap;
    static int maxSafeZone = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        originalMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int wallCnt) {

        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (originalMap[i][j] == 0) { // 빈칸이면
                    // 벽 세우기
                    originalMap[i][j] = 1;
                    dfs(wallCnt + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                copyMap[i][j] = originalMap[i][j];

                if (copyMap[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {

            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
                    if (copyMap[newX][newY] == 0) {
                        copyMap[newX][newY] = 2;
                        q.add(new Node(newX, newY));
                    }
                }
            }
        }

        cntSafeZone(copyMap);
    }

    static void cntSafeZone(int[][] copyMap) {

        int safeZone = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if (safeZone > maxSafeZone) {
            maxSafeZone = safeZone;
        }
    }
    static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
