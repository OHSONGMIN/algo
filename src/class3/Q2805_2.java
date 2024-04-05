package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 0;
        int max = arr[N - 1]; //나무 길이 최솟값
        int mid;

        while (min < max) {
            mid = (min + max) / 2; //나무 길이 중간값
            int sum = 0; //자른 나무 총 길이

            for (int k : arr) {
                if (k - mid > 0) sum += k - mid;
            }

            if (sum < M) { //sum < M -> 나무가 부족하다
                max = mid;
            }
            else { //너무 많이 잘랐다 -> 자르는 높이를 올릴 것
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
