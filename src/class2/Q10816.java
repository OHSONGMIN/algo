package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 { //이진 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int j = 0; j < M; j++) {
            int num = Integer.parseInt(st.nextToken());

            sb.append(upper_Bound(num, arr) - lower_Bound(num, arr)).append(" ");
        }

        System.out.println(sb);
    }

    private static int lower_Bound(int num, int[] arr) {
        int lo = 0;
        int hi = arr.length;
        //upper_Bound(num의 가장 오른쪽 + 1) - lower_Bound(num의 가장 왼쪽) 해야하기 때문에 arr.length-1이 아니라 arr.length라고 한다.

        while (lo < hi) { //lo == hi 될 때까지
            //이 메서드는 중복된 값이 있을 경우 가장 왼쪽 값을 구해야 한다.
            //따라서 num == arr[mid]의 결과가 나타나도
            //hi 값을 내려주어야 한다.
            int mid = (lo + hi) / 2;

            if (num <= arr[mid]) { //최종적으로 arr[mid]이 가장 왼쪽 num일 경우 mid값을 그대로 return 하는 것이고
                hi = mid;
            } else { //num > arr[mid]
                lo = mid + 1;
            }
        }
        return lo; // == hi
    }

    private static int upper_Bound(int num, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) { //lo == hi 될 때까지
            int mid = (lo + hi) / 2;

            if (num < arr[mid]) {
                hi = mid;
            } else { //num >= arr[mid] //최종적으로 arr[min]이 가장 오른쪽 num일 경우 mid + 1을 return한다.
                lo = mid + 1;
            }
        }
        return lo;
    }
}
