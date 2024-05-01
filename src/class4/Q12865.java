package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {
    static int max, N, K;
    static int[] kg, value;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kg = new int[N];
        value = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            kg[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            dfs(i, 0, 0, 0, 0); //물건을 최소 1개에서 N개까지 선택 가능
        }
        System.out.println(max);
    }

    private static void dfs(int cnt, int depth, int sum, int sumValue, int at) {

        if (depth == cnt) {

            if (sum > K) return;
            else {
                max = Math.max(max, sumValue);
                return;
            }
        }
        else {

            for (int i = at; i < N; i++) {

                //if (!visit[i]) {
                    sum += kg[i];
                    sumValue += value[i];
                    //visit[i] = true;
                    dfs(cnt, depth + 1, sum, sumValue, at + 1);
                //}
            }
        }
    }
}
