package class2;

import java.util.Scanner;

public class Q2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = GCD(a, b);
        int lcm = a * b / GCD(a, b);

        System.out.println(gcd);
        System.out.println(lcm);

/*
        long min = a * b;
        int max = 1;

        if (a >= b) {
            for (int i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) max = i;
            }
            for (int i = a; i < min; i++) {
                if (i % a == 0 && i % b == 0) {
                    min = i;
                    break;
                }
            }
        } else {
            for (int i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) max = i;
            }
            for (int i = b; i < min; i++) {
                if (i % a == 0 && i % b == 0) {
                    min = i;
                    break;
                }
            }
        }
        System.out.println(max);
        System.out.println(min);
    }

 */
    }

    private static int GCD(int a, int b) {
        if (a % b == 0) return b;
        else return GCD(b, a % b);
    }
}
