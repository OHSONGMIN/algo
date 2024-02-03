package class1;

import java.util.Scanner;

public class Q13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int room = sc.nextInt();
        int[] arr = new int[room];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int first = sc.nextInt();
        int second = sc.nextInt();

        long count = 0;

        for (int i = 0; i < arr.length; i++) {
            count++; //각 시험장마다 총시험관 1명 필요
            if (arr[i]-first > 0) {
                count += Math.ceil((double)(arr[i] - first) / (double)second);
            }
        }
        System.out.println(count);
    }
}
