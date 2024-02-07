package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        int[] arr = new int[test];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        double max = arr[arr.length-1];
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / max * 100;
        }

        System.out.println(sum / test);
    }
}
