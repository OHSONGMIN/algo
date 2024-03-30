package class3;

import java.util.Scanner;
import java.util.Arrays;

public class Q1931 {

    //종료시간이 빠른 순으로 정렬하고
    //종료시간이 동일하다면 시작시간이 빠른 순으로 정렬한다.
    // 1 3
    // 4 8
    // 8 8 일 때 시작시간이 빠른 순으로 정렬하면 최대 3개의 회의를 할 수 있지만
    // 시간 시간이 느린 순으로 정렬하면 4 8은 건너뛰게 된다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        //끝나는 시간을 기준으로 정렬
        //끝나는 시간이 같다면 시작시간을 기준으로 정렬
        Arrays.sort(arr, (c1, c2) -> {
            if (c1[1] == c2[1]) return c1[0] - c2[0];
            else return c1[1] - c2[1];
        });

        int prevEndTime = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (prevEndTime <= arr[i][0]) {
                prevEndTime = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}