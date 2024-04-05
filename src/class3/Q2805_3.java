package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (max < arr[i]) max = arr[i]; //대신 정렬할 필요 없음
        }

        while (min < max) { //min == max 때 까지
            int mid = (min + max) / 2;
            long sum = 0; //자른 나무 길이

            for (int k : arr) {

                if (k - mid > 0) sum += (k - mid);
            }

            if (sum < M) { //너무 조금 자름 -> 조금 내려야함
                max = mid;
            }
            else { //sum == M || sum > M
                min = mid + 1;
            }
            //나무를 가능한 적게 자르기 위해 sum == M 인 경우에도 계속 시행한다.
            //sum == M인 순간에도 min = mid + 1 을 시행한다는 것은
            //중복값이 존재할 때 자르는 높이를 가능한 한 높게 설정하는 것으로
            //결과는 min - 1 가 된다.
        }
        System.out.println(min - 1);
    }
}
