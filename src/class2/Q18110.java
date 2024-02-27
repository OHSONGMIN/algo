package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) System.out.println(0);
        else {
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            int E = (int) Math.round(N * 0.15);
            double sum = 0;

            for (int i = E; i < N - E; i++) {
                sum += arr[i];
            }

            System.out.println(Math.round(sum / (N - E * 2)));
        }
    }
}
