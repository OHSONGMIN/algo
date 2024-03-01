package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Q1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            arr[i][0] = i;
            arr[i][1] = 0;
        }

        String str = sc.nextLine().toUpperCase();
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 65][1]++;
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
        });

        if (arr[25][1] == arr[24][1]) System.out.println("?");
        else System.out.println((char)(arr[25][0] + 65));
    }
}
