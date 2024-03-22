package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {
    public static List<Integer> list2 = new ArrayList<Integer>();
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> list1 = new ArrayList<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list1.add(num);
            addList2(num);
        }

        Collections.sort(list2);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list1.size(); i++) {
            sb.append(list2.indexOf(list1.get(i))).append(" ");
        }

        System.out.println(sb);
    }

    private static void addList2(int num) {
        if (!list2.contains(num)) list2.add(num);
    }

}
