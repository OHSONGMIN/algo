package class2;

import java.math.BigInteger;
import java.util.Scanner;

public class Q15829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        long result = 0;
        long r = 1;

        int M = 1234567891;

        for (int i = 0; i < N; i++) {
            result += (s.charAt(i) - 'a' + 1) * r % M; //분배법칙
            r = r * 31 % M; //r = (r * 31 % M) % M을 생략할 수 있다.
        }
        System.out.println(result % M);
/*BigInteger*/
        /*
        BigInteger result = BigInteger.valueOf(0);

        for (int i = 0; i < N; i++) {
            int num = s.charAt(i)-'a' + 1;

            BigInteger r = BigInteger.valueOf(1);
            for (int j = 0; j < i; j++) {
                r = r.multiply(BigInteger.valueOf(31));
            }

            result = result.add(r.multiply(BigInteger.valueOf(num)));
        }
        System.out.println(result.mod(BigInteger.valueOf(1234567891)));
         */
    }
}
