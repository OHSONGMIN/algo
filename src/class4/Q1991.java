package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1991 {
    static StringBuilder sb = new StringBuilder();
    //static Queue<Character> queue = new LinkedList<>();
    static int N;
    static char[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken().charAt(0);
            arr[i][1] = st.nextToken().charAt(0);
            arr[i][2] = st.nextToken().charAt(0);
        }

        sb.append(arr[0][0]);
        findLeft(0, 0); //전위
        sb.append("\n");

        //visit = new boolean[N];
        findCenter(0, 0); //중위
        sb.append("\n");

        findRight(0, 0); //후위

        System.out.println(sb);
    }

    private static void findLeft(int i, int j) { //0, 0 시작
        int target = -1;
        for (int k = 0; k < N; k++) {

            if (arr[k][0] == arr[i][j]) target = k;
        }

        if (arr[target][1] != '.') { //arr[i][j]의 left 있다면?

            sb.append(arr[target][1]);
            findLeft(target, 1);
        }

        //arr[i][j]의 right가 있다면
        if (arr[target][2] != '.') {
            sb.append(arr[target][2]);
            findLeft(target, 2);
        }
    }

    private static void findCenter (int i, int j) { //0, 0
        int target = -1;
        for (int k = 0; k < N; k++) {

            if (arr[k][0] == arr[i][j]) target = k;
        }

        //i, j -> 0, 0 ... k -> 1
        //left가 있으면 left를 우선으로 호출....
        if (arr[target][1] != '.') {
            findCenter(target, 1);
        }
        sb.append(arr[target][0]);
        //visit[target] = true;

        //right가 있다면 center넣으면서 right도 넣어야....
        if (arr[target][2] != '.') {
            findCenter(target, 2);
            //sb.append(arr[target][2]);
        }
    }
    private static void findRight(int i, int j) { //0, 0

        int target = -1;
        for (int k = 0; k < N; k++) {

            if (arr[k][0] == arr[i][j]) target = k;
        }

        if (arr[target][1] != '.') {

            findRight(target, 1);
        }

        if (arr[target][2] != '.') {

            findRight(target, 2);
        }
        sb.append(arr[target][0]);

    }
}
