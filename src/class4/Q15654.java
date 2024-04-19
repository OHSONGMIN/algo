package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Q15654 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {

        if (depth == M) {

            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        else {

            for (int i = 0; i < N; i++) {

                if (!visit[i]) { //방문한 적 없다면
                    result[depth] = arr[i];
                    visit[i] = true;
                    dfs(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
