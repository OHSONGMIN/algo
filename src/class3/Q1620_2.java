package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            map.put(i, br.readLine()); // key, value
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (map.containsValue(str)) {
                sb.append(getKey(map, str)).append("\n");
            }

            else if (map.containsKey(Integer.parseInt(str))) {
                sb.append(map.get(Integer.parseInt(str))).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int getKey(Map<Integer, String> map, String str) {

        for (int i = 1; i < map.size() + 1; i++) {
            if (str.equals(map.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
