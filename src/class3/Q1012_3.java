package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1012_3 { //깊이우선탐색(DFS) - Stack 이용
    public static int M;
    public static int N;
    public static int[][] arr;
    public static boolean[][] visit;
    public static Stack<Node> stack= new Stack<>();

    public static int[] dirX = {0, 0, -1, 1};
    public static int[] dirY = {-1, 1, 0, 0};

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

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());

                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            visit = new boolean[M][N];

            int count = 0;

            for (int j = 0; j < M; j++) {
                for (int p = 0; p < N; p++) {

                    if (arr[j][p] == 1 && visit[j][p] == false) {
                        DFS(j, p);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int j, int p) {
        stack.push(new Node(j, p));
        visit[j][p] = true;

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            for (int i = 0; i < 4; i++) {
                int newX = node.x + dirX[i];
                int newY = node.y + dirY[i];

                if (newX >= 0 && newX < M && newY >= 0 && newY < N && visit[newX][newY] == false && arr[newX][newY] == 1) {
                    stack.push(new Node(newX, newY));
                    visit[newX][newY] = true;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
