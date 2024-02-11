package class2;

import java.util.Arrays;
import java.util.Scanner;

public class Q2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        int[] arr = new int[test];
        for (int i = 0; i < test; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for (int i = 0; i < test; i++) {
            System.out.println(arr[i]);
        }
    }
}
