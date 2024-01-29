package class1;

import java.util.Scanner;

public class Q5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
/*수정 코드*/
        int[] arr = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int num = (int)str.charAt(i);

            sum += arr[num-65];
        }

        System.out.println(sum);
/*원래 코드*/
/*
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case 'A': case 'B': case 'C':
                    sum += 3;
                    break;
                case 'D': case 'E': case 'F':
                    sum += 4;
                    break;
                case 'G': case 'H': case 'I':
                    sum += 5;
                    break;
                case 'J': case 'K': case 'L':
                    sum += 6;
                    break;
                case 'M': case 'N': case 'O':
                    sum += 7;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    sum += 8;
                    break;
                case 'T' : case 'U': case 'V':
                    sum += 9;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    sum += 10;
                    break;
            }
        }
        System.out.println(sum);
*/
    }
}
