package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");

            int sum = 0;
            for (String str : arr2) {
                sum += Integer.parseInt(str);
            }

            if (i == 0) total += sum; //첫번째 그룹은 더하기
            else total -= sum; //이후 그룹은 뺴기
        }
        System.out.println(total);
    }
}
