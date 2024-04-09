package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
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
                    count--; //바로 다음에 나올 수도 있으니까
                    result++;
                }
                i++; //i += 2 해야 다음에도 IOI로 나오는지 확인 가능
                //그냥 i += 1 로 하면 OIO가 나올수도...
            }
            else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}
