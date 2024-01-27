package class1;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
/* 방법 1 */
        StringTokenizer st = new StringTokenizer(input);
        System.out.println("st.countTokens() : " + st.countTokens());
/* 방법 2 */
        if (input.equals(" ")) {
            System.out.println(0);
        } else {
            String[] arr = input.trim().split(" ");
            System.out.println(arr.length);
        }
    }
}
