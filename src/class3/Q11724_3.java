package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11724_3 { //BFS 너비우선탐색
    public static boolean[] visit; //노드이기 때문에 2차원 배열로 할 필요는 없음
    public static int[][] arr; //무방향 그래프이기 때문에 2차원 배열로 생성
    public static Queue<Integer> queue = new LinkedList<Integer>();
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
                bfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int i) {
        visit[i] = true;
        queue.offer(i);

        while (!queue.isEmpty()) {
            int n = queue.poll();

            for (int k = 1; k < N + 1; k++) {
                if (!visit[k] && arr[k][n] == 1) { //연결되어있니?
                    visit[k] = true;
                    queue.offer(k);
                }
            }
        }
    }
}
