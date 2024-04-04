package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
    static int[][] arr;
    static boolean[] dfsVisit;
    static boolean[] bfsVisit;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        dfsVisit = new boolean[N + 1];
        bfsVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(V);
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int v) { //재귀함수
        dfsVisit[v] = true;
        sb.append(v).append(" ");

        for (int i = 1; i < N + 1; i++) {

            if (arr[v][i] == 1 && !dfsVisit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int v) { //Queue
        bfsVisit[v] = true;
        sb.append(v).append(" ");

        queue.offer(v);

        while (!queue.isEmpty()) {
            int k = queue.poll();

            for (int i = 1; i < N + 1; i++) {

                if (arr[k][i] == 1 && !bfsVisit[i]) {

                    queue.offer(i);
                    bfsVisit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

    }
}
