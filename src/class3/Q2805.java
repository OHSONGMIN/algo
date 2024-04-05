package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //나무 개수
        long M = Integer.parseInt(st.nextToken()); //필요한 나무

        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long max = arr[N - 1];

        long sum = 0;

        while (true) {
            max--;
            sum = 0;

            for (int i = 0; i < N; i++) {
                long k = arr[i] - max;

                if (k > 0) sum += k;
            }

            if (sum >= M) {
                System.out.println(max);
                break;
            }
        }


    }
}
