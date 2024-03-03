package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            String s = br.readLine();
            map1.put(i, s);
            map2.put(s, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (Character.isDigit(str.charAt(0))) {
                sb.append(map1.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(map2.get(str)).append("\n");
            }
        }

        System.out.println(sb);

    }
}
