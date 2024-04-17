package class4;

import java.util.Scanner;

public class Q15650_3 {
    static int[] arr;
    static boolean[] visit;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visit = new boolean[N+1];

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {

        if (depth == M) {

            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {

            if (!visit[i]) {

                arr[depth] = i;
                visit[i] = true;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
