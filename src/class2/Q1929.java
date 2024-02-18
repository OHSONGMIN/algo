package class2;

import java.io.*;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Boolean[] arr = new Boolean[N+1]; //숫자 i의 소수 여부를 arr[i]에 들어가도록 하기 위해 배열 크기를 N+1로 설정한다.

        arr[0] = false; //소수 아님
        arr[1] = false; //소수 아님

        //2~N까지 일단 true로 설정
        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        //소수 아닌 것을 false로 처리
        for (int i = 2; i * i <= N; i++) {
            if (arr[i] == true) {
                for (int j = i * i; j <= N; j = j + i) { //i * i 이후 i의 배수는 false
                    arr[j] = false;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] == true) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

}
