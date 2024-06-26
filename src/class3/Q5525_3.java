package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int count = 0;
        int result = 0;

        for (int i = 1; i < M-1; i++) {

            if (arr[i-1] == 'I' && arr[i] == 'O' && arr[i+1] == 'I') {
                count++;

                if (count == N) {
                    count--;
                    result++;
                }
                i++;
            }
            else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}
