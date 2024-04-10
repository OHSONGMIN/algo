package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 { //해결방법 : 플로이드 와샬 - 모든 정점에서 모든 정점으로의 거리 구하기
    public static void main(String[] args) throws IOException {
        //플로이드 와샬은 거쳐가는 정점이 중요하다.
        //1 -> 3 을 INF로 설정해놓고
        //arr[1][3] = Math.min(arr[1][3], arr[1][2] + arr[2][3])
        //하고 총 결과에서 INF 이하는 1로 출력, INF 이상은 0으로 출력하면 되겠다??

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int INF = 999999999;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1) arr[i][j] = 1;
                else arr[i][j] = INF;
            }
        }

        for (int k = 0; k < N; k++) { //거쳐가는 정점
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int result = arr[i][j];

                if (result < INF && result > 0) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
