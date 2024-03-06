package class3;

import java.io.*;
import java.util.*;

public class Q11723 {
    public static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String method = st.nextToken();

            if (method.equals("add")) add(Integer.parseInt(st.nextToken()));
            else if(method.equals("remove")) remove(Integer.parseInt(st.nextToken()));
            else if(method.equals("check")) {
                bw.write(check(Integer.parseInt(st.nextToken()))+"\n");
            }
            else if(method.equals("toggle")) toggle(Integer.parseInt(st.nextToken()));
            else if(method.equals("all")) all();
            else if(method.equals("empty")) empty();
        }
        bw.flush();
        bw.close();
    }

    private static void empty() {
        set.clear();
    }

    private static void all() {
        set.clear();

        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    private static void toggle(int i) {
        if (set.contains(i)) set.remove(i);
        else set.add(i);
    }

    private static int check(int i) {
        if (set.contains(i)) return 1;
        else return 0;
    }

    private static void remove(int i) {
        set.remove(i);
    }

    private static void add(int i) {
        set.add(i);
    }
}
