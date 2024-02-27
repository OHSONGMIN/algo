package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        double sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int count = 0; //빈도수
        int max = -1; //최대 빈도수

        int mod = arr[0]; //임의의 값으로 최빈값을 설정
        boolean check = false;

        // 0 1 1 2 3 4 4 4 5 5 5 6 6 6
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++; //4이면 count-2
            } else {
                count = 0;
            }

            if (max < count) { //현재 최대 빈도수라면
                max = count;
                mod = arr[i]; //최빈값으로 설정
                check = true; //최빈값이 1개라는 뜻
            } else if (max == count && check == true) {
                //최대 빈도수를 가지는 값이 여러개이다
                check = false; //arr을 정렬했을 때 처음 check를 true로 설정한 뒤
                //두번째로 같은 최빈값이 등장하면(이때 두번째로 작은 수가 됨) check를 false로 설정해준다.
                //더 높은 빈도수가 등장하지 않는 이상 check는 계속해서 false일 것이다.
                //따라서 (max == count && check == true) 이 조건은
                //최대 빈도수이면서 두번째로 작은 값만 적용된다.
                mod = arr[i];
            }
        }
        System.out.println(Math.round(sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mod);
        System.out.println(arr[N - 1] - arr[0]);
    }
}
