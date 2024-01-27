package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Q2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

/* 다른 방법으로 풀어보자 */
        String input1 = String.valueOf(sc.nextInt());
        String input2 = String.valueOf(sc.nextInt());

        int num1 = (input1.charAt(2)-'0')*100 + (input1.charAt(1)-'0')*10 + (input1.charAt(0)-'0');
        int num2 = (input2.charAt(2)-'0')*100 + (input2.charAt(1)-'0')*10 + (input2.charAt(0)-'0');

        System.out.println(num1 >= num2 ? num1 : num2);
/* 원래 코드 */
/*
        int[] arr = new int[2];

        for (int i = 1; i <= 2; i++) {
            int num = sc.nextInt();

            int a = num/100;
            int b = (num/10)%10;
            int c = num%10;

            num = c*100 + b*10 + a;

            arr[i-1] = num;
        }
        Arrays.sort(arr);
        System.out.println(arr[1]);

*/
    }
}
