package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11724_4 { //DFS 깊이우선탐색
    public static boolean[] visit;
    public static int[][] arr;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //노드의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        visit[i] = true;

        for (int j = 1; j < N + 1; j++) {
            if (!visit[j] && arr[i][j] == 1) {
                dfs(j);
            }
        }
    }
}
