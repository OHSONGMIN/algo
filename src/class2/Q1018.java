package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }
        int count = N * M;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int num = firstBlack(i, j, arr);
                if (count > num) count = num;

                num = firstWhite(i, j, arr);
                if (count > num) count = num;
            }
        }

        System.out.println(count);
    }

    private static int firstWhite(int i, int j, String[][] arr) {
        int count = 0;

        for (int n = i; n < i + 8; n += 2) {
            for (int m = j; m < j + 8; m += 2) {
                if (arr[n][m].equals("B")) count++;
            }

            for (int m = j + 1; m < j+ 8; m += 2) {
                if (arr[n][m].equals("W")) count++;
            }
        }

        for (int n = i + 1; n < i + 8; n += 2) {
            for (int m = j; m < j + 8; m += 2) {
                if (arr[n][m].equals("W")) count++;
            }

            for (int m = j + 1; m < j+ 8; m += 2) {
                if (arr[n][m].equals("B")) count++;
            }
        }

        return count;
    }

    private static int firstBlack(int i, int j, String[][] arr) {
        int count = 0;

        for (int n = i; n < i + 8; n += 2) {
            for (int m = j; m < j + 8; m += 2) {
                if (arr[n][m].equals("W")) count++;
            }

            for (int m = j + 1; m < j+ 8; m += 2) {
                if (arr[n][m].equals("B")) count++;
            }
        }

        for (int n = i + 1; n < i + 8; n += 2) {
            for (int m = j; m < j + 8; m += 2) {
                if (arr[n][m].equals("B")) count++;
            }

            for (int m = j + 1; m < j+ 8; m += 2) {
                if (arr[n][m].equals("W")) count++;
            }
        }

        return count;
    }

}
