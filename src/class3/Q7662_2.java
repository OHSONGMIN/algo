package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q7662_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("I")) map.put(num, map.getOrDefault(num, 0) + 1);
                else { //"D" 라면
                    if (map.isEmpty()) continue;
                    else if (num == 1) { //최댓값 제거
                        int key = map.lastKey();

                        if (map.get(key) == 1) map.remove(key);
                        else map.put(key, map.get(key)-1);
                    }
                    else { //최솟값 제거
                        int key = map.firstKey();

                        if (map.get(key) == 1) map.remove(key);
                        else map.put(key, map.get(key)-1);
                    }
                }
            }

            if (map.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }
        System.out.println(sb);
    }
}
