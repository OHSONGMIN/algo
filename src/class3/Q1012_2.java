package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Q1012_2 { //너비우선탐색(BFS) - Queue 이용
    public static int[] dirX = {0, 0, 1, -1};
    public static int[] dirY = {1, -1, 0, 0};
    public static int[][] arr;
    public static boolean[][] visit;
    public static int M, N;

    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new int[M][N];
            visit = new boolean[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }

            int count = 0;

            for (int j = 0; j < M; j++) {
                for (int h = 0; h < N; h++) {

                    if (visit[j][h] == false && arr[j][h] == 1) {
                        BFS(j, h);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int j, int h) {
        queue.offer(new Node(j, h));
        visit[j][h] = true;

        while (!queue.isEmpty()) {
            Node node = (Node) queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dirX[i];
                int newY = node.y + dirY[i];

                if (newX >= 0 && newX < M && newY >= 0 && newY < N && visit[newX][newY] == false && arr[newX][newY] == 1) {
                    queue.offer(new Node(newX, newY));
                    visit[newX][newY] = true;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
