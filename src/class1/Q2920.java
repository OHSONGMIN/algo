package class1;

import java.util.Scanner;

public class Q2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        char[] arr = input.toCharArray();

        if (arr[0]=='1') {
            for(int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i-1] + 1) {

                }
            }
        }

    }
}
