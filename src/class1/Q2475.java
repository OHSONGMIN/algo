package class1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Q2475 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for(int i = 0; i < 5; i++) {
            int inputNum = sc.nextInt();
            sum += (inputNum * inputNum);
        }
        int checkNum = sum % 10;
        System.out.println(checkNum);
    }
}
