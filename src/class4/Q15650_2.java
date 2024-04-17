package class4;

import java.util.Scanner;

public class Q15650_2 {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];

        dfs(1, 0);

        System.out.print(sb);
    }

    private static void dfs(int at, int depth) {

        if (depth == M) {

            for(int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {

            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
