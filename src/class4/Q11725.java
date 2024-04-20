package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11725 { // 메모리 초과!!
    static int[][] arr;
    static boolean[] visit;
    static int N;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        result = new int[N+1];
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        //System.out.println(arr[1][6]);
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int target) {
        visit[target] = true;

        for (int i = 1; i <= N; i++) {

            if (arr[target][i] == 1 && !visit[i]) {
                result[i] = target;
                dfs(i);
            }
        }
    }
}
