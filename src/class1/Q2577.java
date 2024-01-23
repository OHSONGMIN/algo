package class1;

import java.util.Scanner;

public class Q2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        String num = String.valueOf(a * b * c);

        char[] arr = num.toCharArray();

        for(int i = 0; i <= 9; i++) {
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(i == Character.getNumericValue(arr[j])) count++;
            }
            System.out.println(count);
        }

    }
}
