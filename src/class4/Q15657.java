package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Q15657 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        dfs(0, 0);
        System.out.print(sb);

    }

    private static void dfs(int at, int depth) {

        if (depth == M) {

            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        else {

            for (int i = at ; i < N; i++) {
                result[depth] = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}
