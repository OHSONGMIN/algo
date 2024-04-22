package class4;

import java.util.Arrays;
import java.util.Scanner;

public class Q15663 {
    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    //arr[i]의 i가 1이상이면 i-1이랑 비교하고
    //i == i-1 걍 넘어가기...
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
        System.out.println(sb);
    }

    private static void dfs(int depth) {

        if (depth == M) {

            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        else {
            int before = -1; //detth == 0일 때의 before가 유지, depth == 1일 때의 before가 유지

            for (int i = 0; i < N; i++) {

                if (visit[i]) continue;

                if (before != arr[i]) {

                    visit[i] = true;
                    result[depth] = arr[i];
                    //System.out.println("설정 전 " + before + " depth :" + depth);
                    before = arr[i];
                    //System.out.println("설정 후 " + before);
                    dfs(depth + 1);
                    visit[i] = false;
                }

            }

        }
    }
}
