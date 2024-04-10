package class3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1107 { //시간 초과~~~~~~~~~~~~~~~
    static Set<Integer> set;
    public static void main(String[] args) {
        //고장나지 않는 버튼으로 목표하는 숫자와 가장 가까운 숫자를 만들어서...
        //그 차이만큼 더하면 될까
        //또한 처음 시작 채널 100에서 버튼을 눌렀을 때 누가 더 적은지도 비교해야..
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //목표 채널
        int M = sc.nextInt(); //고장난 버튼 개수
        int min = Integer.MAX_VALUE;

        if (M != 0) {
            set = new HashSet<>();

            for (int i = 0; i < M; i++) {
                set.add(sc.nextInt());
            }

            min = Math.min(findForMin(N), findForMax(N));
            min = Math.min(min, findForOne(N));
        }

        else { // M == 0
            min = Math.min(String.valueOf(N).length(), findForOne(N));
        }

        System.out.println(min);
    }

    private static int findForOne(int n) {
        if (n == 100) {
            return 0;
        }
        else {
            return Math.abs(n - 100);
        }
    }

    private static int findForMax(int n) { //n보다 큰 숫자 중에서 가장 작은 수
        int num = n;
        while(true) {

            String str = String.valueOf(num);

            boolean check = true;

            if (!set.contains(0) && set.size() == 9) break;

            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i) - '0')) {
                    check = false;
                }
            }
            if(check) return (num - n) + String.valueOf(num).length();
            num++;
        }
        return Integer.MAX_VALUE;
    }

    private static int findForMin(int n) { //n보다 작은 숫자 중에서 가장 큰 수
        int num = n;
        while(true) {

            String str = String.valueOf(num);

            boolean check = true;

            for (int i = 0; i < str.length(); i++) {
                if (set.contains(str.charAt(i) - '0')) {
                    check = false;
                }
            }

            if (check) {
                return (n - num) + String.valueOf(num).length();
            }
            num--;
            if (num < 0) break;
        }
        return Integer.MAX_VALUE;
    }
}
