package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    public static int[][] arr = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /*0 - 1 0
        1 - 0 1
        2 - 1 1
        3 - 1 2
        4 - 2 3
        5 - 3 5
        6 - 5 8
        7 - 8 13
        8 - 13 21
        9 - 21 34
        10 - 34 55
         */
        arr[0][0] = 1;
        arr[0][1] = 0;
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i][0] = arr[i-1][1];
            arr[i][1] = arr[i-1][0] + arr[i-1][1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");

        }

        System.out.println(sb);

    }
}
