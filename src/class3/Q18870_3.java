package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q18870_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        Set set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }

        StringBuilder sb = new StringBuilder();

        Object[] sorted = set.stream().sorted().toArray();

        for (int i : arr) {
            sb.append(Arrays.binarySearch(sorted, i)).append(" ");
        }

        System.out.println(sb);
    }
}
