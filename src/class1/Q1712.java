package class1;

import java.util.Scanner;

public class Q1712 {
    public static void main(String[] args) {
        //고정비용 가변비용 노트북가격
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); //고정비용
        int b = sc.nextInt(); //가변비용(노트북 한대 만들때 필요한 비용)
        int c = sc.nextInt(); //노트북 판매 가격

        if (b > c) {
            System.out.println(-1);
        } else {

            int n = a / (c - b) + 1;
            System.out.println(n);
        }
    }
}
