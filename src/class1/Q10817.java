package class1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q10817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Integer[] arr = new Integer[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }

        //Arrays.sort(arr);

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(arr[1]);
    }
}
