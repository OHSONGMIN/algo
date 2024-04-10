package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br. readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            boolean check = false;

            for (int j = x; j <= M * N; j = j + M) {
                //주어진 수 j에 대해
                //j % M = x 이고 j % N = y 이다.
                //x += M 마다 y의 값이 변화하므로
                //j % M == x 일 때, j % N == y 인 값을 찾으면 된다.
                if (j % N == y) { //j = 60 일 때, 60 % 12 == 0이다.... 이는 y와 절대 같을 수 없음

                    sb.append(j + 1).append("\n");
                    check = true;
                    break;
                }
            }

            if (!check) { //j 값을 찾지 못했다면
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
