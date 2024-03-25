package class3;

import java.util.Scanner;

public class Q2630 {
    public static int[][] arr;
    public static int N;
    public static int white;
    public static int blue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        countConfetti(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void countConfetti(int i, int j, int size) {

        if (oneConfetti(i, j, size)) { //true이면 같이 색상이라는 뜻
            if (arr[i][j] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        //같은 색상이 아닐 경우 반으로 나눠서 다시 countConfetti 실행
        int newSize = size / 2;

        //재귀호출
        countConfetti(i, j, newSize); //2사분면
        countConfetti(i, j + newSize, newSize); //3사분면
        countConfetti(i + newSize, j, newSize); //1사분면
        countConfetti(i + newSize, j + newSize, newSize); //4사분면
    }

    private static boolean oneConfetti(int row, int col, int size) { //같은 색인지 확인하는 메서드

        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(arr[i][j] != color) return false; //다른 색이 나온다면 false를 return
            }
        }
        return true; //모두 같은 색이라면 최종적으로 true를 return
    }


}
