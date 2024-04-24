package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Q15666_2 {
    static int[] arr;
    static int[] result;
    static int N, M;
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
        System.out.println(sb);

    }

    private static void dfs(int at, int depth) {

        if (depth == M) {

            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        else {
            int before = -1;

            for (int i = at; i < N; i++) {

                if (arr[i] == before) continue;

                result[depth] = arr[i];
                before = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}
