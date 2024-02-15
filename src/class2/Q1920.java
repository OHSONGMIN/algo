package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //test 값

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        //arr 정렬 후 이분 탐색 사용
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(numCheck(arr, target, 0, arr.length - 1)).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static String numCheck(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target < arr[mid]) { //target이 arr[mid]보다 작을 때
                end = mid - 1;
            } else if (target > arr[mid]) { //target이 arr[mid]보다 클 때
                start = mid + 1;
            } else { //target이 arr[mid]와 같은 때
                return "1";
            }

        } //start이 end를 넘을 때까지 찾았는데 없다면 해당 arr에 존재하지 않는 것
        return "0";
    }
}
