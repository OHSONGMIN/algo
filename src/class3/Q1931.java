//종료시간이 빠른 순으로 정렬하고
//종료시간이 동일하다면 시작시간이 빠른 순으로 정렬한다.
// 1 3
// 4 8
// 8 8 일 때 시작시간이 빠른 순으로 정렬하면 최대 3개의 회의를 할 수 있지만
// 시간 시간이 느린 순으로 정렬하면 4 8은 건너뛰게 된다.

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        
        int[][] time = new int[N][2];


        for(int i = 0; i < N; i++) {
            time[i][0] = in.nextInt();	// 시작시간
            time[i][1] = in.nextInt();	// 종료시간
        }


        // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0; i < N; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }

}