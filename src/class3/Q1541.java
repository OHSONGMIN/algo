package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 { //아아아아아니 괄호를 무한으로 할 수 있는지 몰랐음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        최솟값을 찾기 위해선 minus되는 값이 가장 커야한다.
        따라서 minus를 기준으로 나누고 가장 큰 값에 괄호() 를 넣는다고 가정...
        */

        String[] arr = br.readLine().split("-"); //"-"로 배열에 넣음

        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");

            int sum = 0;
            for (String k : arr2) {
                sum += Integer.parseInt(k);
            }

            max = Math.max(max, sum);
        }

        int total = 0;
        for (String str : arr) {
            String[] arr3 = str.split("\\+");

            for (int i = 0; i < arr3.length; i++) {
                total += Integer.parseInt(arr3[i]);
            }
        }
        System.out.println(total - max * 2);

    }
}
