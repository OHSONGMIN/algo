package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) System.out.println(1);
        else System.out.println(bee(N));
    }

    private static int bee(int num) {
        int n = 1;
        int sum = 1;

        while (num > sum) {
            sum += 6 * n;
            n++;
        }
        return n;
    }
}
