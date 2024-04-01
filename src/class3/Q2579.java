package class3;

import java.util.Scanner;

public class Q2579 {
    public static int[] arr;
    public static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0]; //Integer의 기본값은 null, arr[0] = 0 으로 초기화
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(N));
    }

    private static int find(int num) {
        //아직 탐색되지 않은 계단일 경우
        if (dp[num] == null) {
            dp[num] = Math.max(find(num-3) + arr[num-1], find(num-2)) + arr[num];
        }

        return dp[num];
    }

}
