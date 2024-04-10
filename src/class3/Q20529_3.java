package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20529_3 { //비둘기집 원리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if (N > 32) { //세 사람의 심리적인 거리가 가장 적은 값을 구해야하는데
                //N이 33이상이라면
                //같은 MBTI가 적어도 3번은 등장하게 된다. <- 비들기집 원리
                //이때 심리적인 거리는 0으로 N이 33이상일 경우는 계산할 필요가 없다.
                sb.append(0).append("\n");
                continue;
            }
            //N <= 32
            String[] MBTI = new String[N];

            for (int j = 0; j < N; j++) {
                MBTI[j] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for (int j = 0; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) { //012 013 014 015... 023
                    for (int p = k + 1; p < N; p++) {
                        int sum = 0;
                        for(int n = 0; n < 4; n++) {
                            if (MBTI[j].charAt(n) != MBTI[k].charAt(n)) sum++;
                            if (MBTI[k].charAt(n) != MBTI[p].charAt(n)) sum++;
                            if (MBTI[p].charAt(n) != MBTI[j].charAt(n)) sum++;
                        }
                        min = Math.min(min, sum);
                        if (min == 0) break;
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
}
