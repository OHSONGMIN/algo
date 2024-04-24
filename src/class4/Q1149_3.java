package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149_3 { //반복문 // bottom-up
    static int N;
    static int[][] arr;
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][Red] = Integer.parseInt(st.nextToken());
            arr[i][Green] = Integer.parseInt(st.nextToken());
            arr[i][Blue] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            arr[i][Red] = arr[i][Red] + Math.min(arr[i-1][Green], arr[i-1][Blue]);
            arr[i][Green] = arr[i][Green] + Math.min(arr[i-1][Red], arr[i-1][Blue]);
            arr[i][Blue] = arr[i][Blue] + Math.min(arr[i-1][Red], arr[i-1][Green]);
        }

        System.out.println(Math.min(arr[N-1][Red], Math.min(arr[N-1][Green], arr[N-1][Blue])));
    }
}
