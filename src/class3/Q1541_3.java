package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1541_3 { //StringTokenizer 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.MAX_VALUE;

        //1. "-"를 기준으로 나눈다.
        StringTokenizer minusStr = new StringTokenizer(br.readLine(), "-");

        while (minusStr.hasMoreTokens()) { //값이 있다면.....
            int sum = 0;

            //2. "+"를 기준으로 나눈다.
            StringTokenizer plusStr = new StringTokenizer(minusStr.nextToken(), "\\+");

            while (plusStr.hasMoreTokens()) {
                int k = Integer.parseInt(plusStr.nextToken());

                sum += k;
            }

            if (total == Integer.MAX_VALUE) { //total이 Integer.MAX_VALUE와 같다면(즉, 초기값이라면)
                total = sum;
            } else {
                total -= sum;
            }
        }
        System.out.println(total);
    }
}
