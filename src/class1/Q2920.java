package class1;

import java.util.Arrays;
import java.util.Scanner;

public class Q2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

/* 수정 코드 */
        int[] asd = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] des = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] input = new int[8];

        for(int i = 0; i < 8; i++) {
            input[i] = sc.nextInt();
        }

        if (Arrays.equals(asd, input)) {
            System.out.println("ascending");
        } else if (Arrays.equals(des, input)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

        /* 원래 코드 */
        /*
        int start = sc.nextInt();

        if (start == 1) {
            for (int i = 1; i < 8; i++) {
                start++;
                if (start != sc.nextInt()) {
                    System.out.println("mixed");
                    return;
                };
            }
            System.out.println("ascending");
        }

        else if (start == 8) {
            for (int i = 1; i < 8; i++) {
                start--;
                if (start != sc.nextInt()) {
                    System.out.println("mixed");
                    return;
                };
            }
            System.out.println("descending");
        }

        else {
            System.out.println("mixed");
        }
        */
    }
}
