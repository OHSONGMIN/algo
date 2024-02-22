package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= N; i++) { //1~N까지 각각 5로 나뉘는지 계산
            int k = i; //i는 독립적으로 증가하도록 k에 i를 대입
            while (k % 5 == 0) { //i가 5의 배수라면
                count++; //count++ 하고
                k /= 5; //i를 5로 나눈 뒤 5로 나눠지지 않을 때까지 반복
            }
        }
        System.out.println(count);
/* 0의 개수를 직접 세는 방법 */
        /*
        BigInteger num = new BigInteger("1");
        for (int i = 1; i <= N; i++) {
            num = num.multiply(BigInteger.valueOf(i));
        }

        int count = 0;

        String str = num.toString();
        for (int i = str.length()-1; i >= 0; i--) {
            if ((str.charAt(i)-'0') == 0) count++;
            else break;
        }
        System.out.println(count);
         */
    }
}
