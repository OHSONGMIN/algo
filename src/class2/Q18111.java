package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = 0; //최대 높이
        int min = 256; //최소 높이

        int num;

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;

                if (num < min) min = num; //입력값 중 최소값
                if (num > max) max = num; //입력값 중 최대값
            }
        }

        //최소 시간 구하기
        int time = 0; //time 선언

        int minTime = Integer.MAX_VALUE; //최소 시간 선언
        int height = 0; //최소 시간이 같다면 더 높은 높이로...

        for (int k = min; k <= max; k++) {
            time = 0;
            int block = B; //보유 블럭, 기준 높이 k가 변할 때마다 block 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > k) {
                        int gap = Math.abs(arr[i][j] - k);
                        block += gap;
                        time += gap * 2;
                    }
                    else if (arr[i][j] < k) {
                        int gap = Math.abs(arr[i][j] - k);
                        block -= gap;
                        time += gap;
                    }
                }
            }

            if (block >= 0 && time < minTime) {
                height = k;
                minTime = time;
            } else if (block >= 0 && time == minTime && k > height) {
                height = k;
            }
        }

        System.out.println(minTime + " " + height);
    }
}
