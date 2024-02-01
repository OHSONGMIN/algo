package class1;

import java.util.Scanner;

public class Q10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

//N개의 배열 만들기
        int[] arr = new int[N+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

//배열 위치 바꾸기
        for (int num = 0; num < M; num++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
//출력하기
        for (int i = 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
