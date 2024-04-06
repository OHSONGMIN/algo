package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1389_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        int INF = 999999999;

        for (int i = 1; i <= N; i++) { //초기값 설정
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;

                if (i == j) arr[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) { //직접 연결된 정점
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        //플로이드 와샬 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        //케빈 베이컨의 수가 가장 적은 사람 출력(동점자가 있을 경우 가장 작은 사람)
        int min = Integer.MAX_VALUE; //가장 적은 게빈 베이컨 수
        int result = -1; //사람, 인덱스

        for (int i = 1; i <= N; i++) {
            int sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += arr[i][j];
            }

            if (sum < min) {
                //sum <= min 이 아닌 sum < min으로 설정해
                //동점자일 경우 가장 작은 사람을 출력하라는 점도 해결
                result = i;
                min = sum;
            }
        }

        System.out.println(result);
    }
}
