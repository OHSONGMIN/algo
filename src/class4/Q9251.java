package class4;

import java.util.Scanner;

public class Q9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input1 = sc.nextLine().toCharArray();
        char[] input2 = sc.nextLine().toCharArray();

        int max = 0;
        for (int i = 0; i < input1.length; i++) {
            int sum = 0;

            for (int j = i; j < input1.length; j++) {
                int num = 0;

                for (int k = num; k < input2.length; k++) {
                    if (input1[j] == input2[k]) {
                        sum++;
                        num = k + 1;
                        break;
                    }
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
