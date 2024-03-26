package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11724_2 { //x, y 하나만 같아도 연결됨
    public static int[][] arr;
    public static boolean[][] visit;
    public static Queue<Integer> queue = new LinkedList<Integer>();

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
                if(arr[i][j] == 1 && !visit[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int i, int j) {
        visit[i][j] = visit[j][i] = true;

        queue.offer(i);
        queue.offer(j);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int k = 0; k < 1001; k++) {
                if (arr[n][k] == 1 && !visit[n][k]) {
                    queue.offer(k);
                    visit[n][k] = true;
                }
                if (arr[k][n] == 1 && !visit[k][n]) {
                    queue.offer(k);
                    visit[k][n] = true;
                }
            }
        }

    }
}
