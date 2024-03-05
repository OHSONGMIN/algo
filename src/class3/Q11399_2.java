package class3;

import java.util.Scanner;

public class Q11399_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int[] arr = new int[1001];

        for (int i = 0; i < N; i++) {
            arr[sc.nextInt()]++;
        }

        int totalSum = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] > 0) {
                sum += i;
                totalSum += sum;
                arr[i]--;
            }
        }

        System.out.println(totalSum);
    }
}
