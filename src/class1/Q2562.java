package class1;

import java.util.Scanner;

public class Q2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] match = new int[9];

        for (int i = 0; i < 9; i++) {
            match[i] = Integer.parseInt(sc.nextLine());
        }

        int temp = 0;

        for(int i = 0; i < 9; i++) {
            if (match[i] > temp) {
                temp = match[i];
            }
        }
//        for (int i = 0; i < 9; i++) {
//            for (int j = 1; j <= 8-i; j++) {
//                if (match[i] > match[i+j]) {
//                    temp = match[i];
//                } else if (match[i] < match[i+j]) {
//                    temp = match[i+j];
//                }
//            }
//        }

        System.out.println(temp);

        for (int i = 0; i < 9; i++) {
            if (temp == match[i]) {
                System.out.println(i+1);
            }
        }
    }
}
