package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {

    static final int dx[] = {0, 0, -1, 1}; //x 상하좌우
    static final int dy[] = {-1, 1, 0, 0}; //y 상하좌우
    static int[][] originalMap; //oriMap
    static int n, m; //Map크기
    static int maxSafeZone = Integer.MIN_VALUE; //최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        originalMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    //wallCnt는 현재 0
    static void dfs(int wallCnt) {
        //벽을 3개 설치한 후 bfs 탐색
        if(wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs (wallCnt + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        // 일단 원본에서 바이러스 감염된 곳은 queue에 넣음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (originalMap[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }

        // 원본을 해치지 않기 위해 복사
        int copyMap[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyMap[i][j] = originalMap[i][j];
            }
        }

        // BFS 탐색
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                // 연구소 범위 안이고 빈칸일 경우에만 바이러스를 퍼트린다.
                if (0 <= newX && 0 <= newY && newX < n && newY < m) {
                    if (copyMap[newX][newY] == 0) {
                        q.add(new Node(newX, newY));
                        copyMap[newX][newY] = 2;
                    }
                }
            }
        }

        //safeNoze 계싼
        funcSafeZone(copyMap);
    }

    private static void funcSafeZone(int[][] copyMap) {
        int safeZone = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if (maxSafeZone < safeZone) {
            maxSafeZone = safeZone;
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
