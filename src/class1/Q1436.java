package class1;

import java.util.Scanner;

public class Q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1; //666이 들어가는 가장 작은 수는 666이다.
        int i = 666;
        while (count != num) { //num이 1일 경우 바로 666이 출력될 것.
            i++;
            if (Integer.toString(i).contains("666")) count++;
        }
        System.out.println(i);
    }
}
