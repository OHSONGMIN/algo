package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725_2 {
    // static int[][] arr; 이 아닌 ArrayList<Integer>[] 을 만들어야 함
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int N;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visit = new boolean[N+1];
        parents = new int[N+1];

        arr = new ArrayList[N+1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int index) {
        visit[index] = true;

        for (int i : arr[index]) {

            if (!visit[i]) {
                parents[i] = index;
                dfs(i);
            }
        }
    }
}
