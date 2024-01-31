package class1;

import java.util.Scanner;

public class Q10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
/* 수정 코드 - 메서드로 만들어보자 */
        System.out.println(fibo(num));

/* 기존 코드 */
        /*
        if (num < 2) {
            System.out.println(num);
        } else {
            int[] arr = new int[num+1];
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i <= num; i++) {
                arr[i] = arr[i-2] + arr[i-1];
            }

            System.out.println(arr[num]);
        }
         */
    }
    private static int fibo(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibo(num-1) + fibo(num-2);
    }
}
