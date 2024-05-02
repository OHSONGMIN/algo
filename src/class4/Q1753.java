package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1753 {
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점의 개수
        int E = Integer.parseInt(st.nextToken()); //간선의 개수
        int start = Integer.parseInt(br.readLine());

        int[][] arr = new int[V+1][V+1];
        Integer[][] result = new Integer[V+1][V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < V+1; i++) {
            result[i][i] = 0;
        }

        for (int i = 1; i < V+1; i++) {
            for (int j = 1; j < V+1; j++) {
                for (int k = 1; k < V+1; k++) {


                }
            }
        }

    }

    private static void bfs(int i) {
        queue.offer(i);

        while (!queue.isEmpty()) {




        }

    }
}
