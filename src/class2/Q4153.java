package class2;

import java.util.Arrays;
import java.util.Scanner;

public class Q4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0) break;

            int[] arr = {a * a, b * b, c * c};
            Arrays.sort(arr);

            if(arr[2] == arr[0] + arr[1]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
