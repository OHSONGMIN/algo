package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long lo = 0;
        long hi = arr[K-1]; //최대값에 + 1을 해야하는 이유는 upper_Bound에서 -1 값을 출력할 것이기 때문에

        hi++;

        long mid = 0;

        while(lo < hi) { //lo < hi일 땐 반복, lo == hi이면 끝
            mid = (lo + hi) / 2;

            long count = 0;

            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }
}
