package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(avg(arr));
        System.out.println(mid(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));
    }

    private static int range(int[] arr) {
        Arrays.sort(arr);

        return arr[arr.length - 1] - arr[0];
    }

    private static int mode(int[] arr) {
        int[][] arrCount = new int[8001][2];

        for (int i = 0; i < arr.length; i++) {
            arrCount[arr[i] + 4000][0] = arr[i];
            arrCount[arr[i] + 4000][1]++;
        }

        Arrays.sort(arrCount, (e1, e2) -> {
            if (e1[1] == e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1];
        });

        if (arrCount[arrCount.length - 1][1] != arrCount[arrCount.length - 2][1]) return arrCount[arrCount.length - 1][0];
        else { //여러 개가 있다면
            int i = arrCount.length - 2;
            while (arrCount[i][1] == arrCount[arrCount.length - 1][1]) {
                i--;
            } //arrCount[n][1] 값이 달라지면 두 번째로 작은 수를 구해야하므로
            //i - arrCount[n][1] 값이 다름
            //i + 1 - arrCount[n][1] 값은 같으면서 arrCount[n][0] 값은 가장 작음
            //i + 2 두번째로 작음
            return arrCount[i + 2][0];
        }
    }

    private static int mid(int[] arr) {
        int M = arr.length / 2;
        
        return arr[M];
    }

    private static int avg(int[] arr) {
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return (int) Math.round(sum / arr.length);
    }
}
