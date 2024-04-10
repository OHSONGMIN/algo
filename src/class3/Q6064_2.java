package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1; //이전 값
            int y = Integer.parseInt(st.nextToken()) - 1; //이전 값

            boolean check = false;

            for (int k = x; k <= M * N; k += M) {

                if (k % N == y) {
                    sb.append(k + 1).append("\n");
                    check = true;
                    break;
                }
            }

            if (!check) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
