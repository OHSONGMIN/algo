package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                if (str.equals(arr[j])) {
                    sb.append(j).append("\n");
                    break;
                } else if (str.equals(Integer.toString(j))) {
                    sb.append(arr[j]).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
