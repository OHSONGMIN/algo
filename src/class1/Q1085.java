package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

/*개선한 코드*/
        int result = Math.min(Math.min(w, x-w), Math.min(h, y-h));
        System.out.println(result);
/*원래 코드*/
/*
        int[] arr = new int[4];

        arr[0] = w - 0;
        arr[1] = h - 0;
        arr[2] = x - w;
        arr[3] = y - h;

        Arrays.sort(arr);

        System.out.println(arr[0]);
*/
    }
}
