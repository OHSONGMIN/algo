package class1;

import java.util.Scanner;

public class Q2231 {
    private static int sumNum(int i) {
        int sum = i;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
/* while로 다시 해보자 %10 /10 이용해서 */

        for (int i = 1; i <= input; i++) {
            if(sumNum(i) == input) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);

/* 원래 코드 */ /*
        for (int i = 1; i <= input; i++) { //메서드 만들어서 다시 해볼까
            char[] arr = String.valueOf(i).toCharArray();
            int sum = i;

            for(int j = 0; j < arr.length; j++) {
                sum += arr[j]-'0';
            }

            if (sum == input) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
        */
    }
}
