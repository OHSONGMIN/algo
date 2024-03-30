package class3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt(); //동전 종류를 배열에 담고
        }
        Arrays.sort(arr, Comparator.reverseOrder()); //역순 정렬하기 위해선 int[]이 아닌 Integer[]로 해야함

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = arr[i];

            //동전의 가치가 K보다 작거나 같아야 함
            if (K >= num) {
                //현재 가치의 동전으로 구성할 수 있는 개수를 더해줌
                cnt += K / num;
                K %= num;
            }
        }
        System.out.println(cnt);
    }
}
