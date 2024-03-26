package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11724 {
    public static int[] dirX = {0, 0, -1, 1};
    public static int[] dirY = {-1, 1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visit;
    public static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        arr = new int[1001][1001];
        visit = new boolean[1001][1001];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int cnt = 0;

        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    visit[i][j] = visit[j][i] = true;
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int i, int j) {
        queue.offer(new Node(i, j));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int a = node.a;
            int b = node.b;

            //1, 2
            for (int k = 0; k < 4; k++) {
                int newX = a + dirX[k]; //1,1 1,3 0,2 2,2
                int newY = b + dirY[k];

                if (newX >= 1 && newX <= 1000 && newY >= 1 && newY <= 1000 && !visit[newX][newY] && arr[newX][newY] == 1) {
                    queue.offer(new Node(newX, newY));
                    queue.offer(new Node(newY, newX));
                    visit[newX][newY] = visit[newY][newX] = true;
                }
            }
        }
    }

    static class Node {
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
        int a;
        int b;

    }
}
