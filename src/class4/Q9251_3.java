package class4;

import java.util.Scanner;

public class Q9251_3 { // Top - down
    static char[] str1, str2;
    static Integer[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine().toCharArray();
        str2 = sc.nextLine().toCharArray();

        dp = new Integer[str1.length][str2.length];
        //int[][]의 크기를 str1.length+1, str2.length+1로 설정하지 않아서
        //dp[i-1][j-1]할 때 ArrayIndexOutOfBoundsException 발생할 수도 있지만
        //Top - down 방식의 재귀함수를 이용하기 때문에
        //-1값이 나올 때 적절한 값으로 return 해주면 된다.

        System.out.println(LCS(str1.length-1, str2.length-1));
    }

    private static int LCS(int x, int y) {

        //인덱스 밖일 경우 0 반환
        if (x == -1 || y == -1) {
            return 0;
        }

        //탐색하지 않은 인덱스라면?
        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (str1[x] == str2[y]) {
                dp[x][y] = LCS(x-1, y-1) + 1;
            }
            else {
                dp[x][y] = Math.max(LCS(x, y-1), LCS(x-1, y));
            }
        }
        return dp[x][y];
    }
}
