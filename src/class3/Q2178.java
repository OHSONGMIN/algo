package class3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    static int[][] arr;
    static int N, M;
    static boolean[][] visit;
    static Queue<Node> queue = new LinkedList<>();
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
            String input = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) -'0';
            }
        }
        bfs();
        System.out.println(arr[N-1][M-1]);
    }

    private static void bfs() {
        queue.offer(new Node(0, 0));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dirX[i];
                int newY = y + dirY[i];

                if (newX >= 0 && newX < N && newY >= 0 && newY < M && !visit[newX][newY] && arr[newX][newY] != 0) {
                    arr[newX][newY] = arr[x][y] + 1;
                    visit[newX][newY] = true;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
    }

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
}