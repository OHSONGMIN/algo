package class1;

import java.util.Scanner;

public class Q1157_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int[] arr = new int[26];

        for (int i =0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (65 <= ch && ch <= 90) {
                arr[ch - 'A']++;
            }

            else { // 97 ~ 122
                arr[ch - 'a']++;
            }
        }

        int max = -1;
        char result = '?';

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = (char) (i + 65);
            }
            else if (arr[i] == max) {
                result = '?';
            }
        }

        System.out.println(result);


    }
}
