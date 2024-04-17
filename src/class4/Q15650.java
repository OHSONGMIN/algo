package class4;

import java.util.Scanner;

public class Q15650 {
    static int[] arr;
    static int N, M, count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        count = 1;
        for (int i = 1; i <= N; i++) {
            dfs(count, i + 1, i + " ");
        }
        System.out.println(sb);

    }

    private static void dfs(int count, int start, String str) {

        if (count == M) {
            sb.append(str).append("\n");
        }
        else {
            for (int i = start; i <= N; i++) {
                dfs(count + 1, i + 1, str + i + " ");
            }
        }
    }
}
