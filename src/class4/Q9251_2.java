package class4;

import java.util.Scanner;

public class Q9251_2 { // Bottom - up
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();

        int length1 = str1.length;
        int length2 = str2.length;

        int[][] dp = new int[length1+1][length2+2];

        for (int i = 1; i < length1+1; i++) {

            for (int j = 1; j < length2+1; j++) {

                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[length1][length2]);
    }
}
