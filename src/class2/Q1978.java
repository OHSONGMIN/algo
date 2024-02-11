package class2;

import java.util.Scanner;

public class Q1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
/* 숫자 % 숫자 == 0 이 2개인 것만 count 하기 */
        int count = 0;

        for (int i = 0; i < test; i++) {
            int num = sc.nextInt();
            int check = 0;

            if (num == 1) continue;

            for (int j = 1; j <= num; j++) {
                if (num % j == 0) check++;
            }

            if (check == 2) count++;
        }

        System.out.println(count);
/* 전체 숫자에서 소수가 아닌 개수 빼기 */
        /*
        int count = test;

        for (int i = 0; i < test; i++) {
            int num = sc.nextInt();

            if (num == 1) {
                count--;
                continue;
            }

            if (num == 2) {
                continue;
            }

            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
        */
    }
}
