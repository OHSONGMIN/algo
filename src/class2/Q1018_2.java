package class2;

import java.util.Scanner;

public class Q1018_2 {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'B')  arr[i][j] = false; //black
                else arr[i][j] = true; //white
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                changeColor(i, j);
            }
        }
        System.out.println(min);
    }

    private static void changeColor(int i, int j) {
        int count = 0;

        boolean TF = arr[i][j]; //첫 시작은?

        for (int n = i; n < i + 8; n++) {
            for (int m = j; m < j + 8; m++) {

                if (arr[n][m] != TF) count++;
                /*
                 * if문을 한번 실행할 때마다
                 * TF = !TF를 해서 색이 번갈아 나오도록 하며
                 * TF가 다음 칸과 일치하는지 확인
                 */
                TF = !TF;
            }
            /*
             * 8 x 8 로 이루어진 바둑판은
             * 다음 줄로 넘어가면
             * 그 줄의 시작은 또 반대로 바뀌기 때문에
             * for 문을 한 차례 실행하고 다시 TF = !TF 해준다.
             */
            TF = !TF;
        }

        /*
        arr[i][j]의 시작 색깔이 White일 때, Black일 때
        색칠한 칸 수는 count 와 64 - count일 것이다.
        따라서 둘 중 최소값을 구한다
         */
        count = Math.min(count, 64 - count);

        /*
         * 현재 최솟값과 count를 비교
         */
        min = Math.min(min, count);
    }
}
