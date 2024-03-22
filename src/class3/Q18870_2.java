package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q18870_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] origin = new int[N]; //원본 배열
        int[] sorted = new int[N]; //정렬할 배열

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            origin[i] = sorted[i] = num; //배열에 저장
        }

        Arrays.sort(sorted); //sorted 배열 정렬

        Map<Integer, Integer> rankMap = new HashMap<>(); //num, rank 저장할 Map 생성

        int rank = 0;
        for (int i : sorted) {
            /*
            중복으로 저장되지 않도록
            Map에 i값이 없을 때만 put 하고
            rank 를 Value 값으로 하여 순위를 매길 수 있도록 한다.
             */
            if (!rankMap.containsKey(i)) { //i가 map에 없다면
                rankMap.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : origin) {
            sb.append(rankMap.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
