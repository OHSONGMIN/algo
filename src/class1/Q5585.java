package class1;

import java.util.Scanner;

public class Q5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = 1000 - sc.nextInt();
        int count = 0;

        count += price / 500;
        count += price % 500 / 100;
        count += price % 100 / 50;
        count += price % 50 / 10;
        count += price % 10 / 5;
        count += price % 5;

        System.out.println(count);
    }
}
