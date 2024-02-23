package class2;

import java.util.Scanner;

public class Q2775 {
    static int[][] arr = new int[15][15]; //재귀함수 이용하기 위해

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
/*재귀함수를 이용해보자 - 먼저 main 메서드 바깥에 in[][] 선언*/
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();
            sb.append(arrNum(K, N)).append("\n");
        }

        System.out.println(sb);
/*값을 출력하기 전에 배열에 알맞는 수를 넣어줬음*/
        /*
        int[][] arr = new int[15][15];
        for (int i = 0; i < 15; i++) {
            arr[i][0] = 0;
            arr[i][1] = 1;
            arr[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
           for (int j = 2; j < 15; j++) {
                arrNum(i, j, arr);
            }
        }

        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            int N = sc.nextInt();

            System.out.println(arr[K][N]);
        }
    */
    }

    private static int arrNum(int k, int n) {
        if (arr[k][n] != 0) return arr[k][n];
        else if (k == 0) return arr[0][n] = n;
        else if (n == 0) return arr[k][0] = 0;
        else return arr[k][n-1] + arr[k-1][n];
    }

/*
    private static void arrNum(int i, int j, int[][] arr) {
        int sum = 0;
        for (int k = 0; k <= j; k++) {
            sum += arr[i-1][k];
        }
        arr[i][j] = sum;
    }
*/

}
