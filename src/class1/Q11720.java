package class1;

import java.util.Scanner;

public class Q11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rep = Integer.parseInt(sc.nextLine());
        String ele = sc.nextLine();

        int sum = 0;

        for (int i = 0; i < rep; i++) {
            sum += Integer.parseInt(ele.substring(i, i+1));
        }

        System.out.println(sum);
    }
}
