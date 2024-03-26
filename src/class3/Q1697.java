package class3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1697 {
    public static int N;
    public static int K;
    //public static int[] arr;
    public static int[] visit; //소요 시간을 나타내는 배열, 값이 0인 곳은 방문한 적 없는 곳
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //내 처음 위치
        K = sc.nextInt(); //동생 위치
        visit = new int[100001];

        System.out.println(distance(N)); //K까지 도달하는 데 걸린 시간
    }

    private static int distance(int n) {
        queue.offer(n);
        visit[n] = 1; //소요 시간, 시작point는 사실 0초이지만 실행 조건을 위해 1로 설정, -1 해서 계산
        int point = n; //현재 위치

        while (!queue.isEmpty()) {
            point = queue.poll();

            if (point == K) return visit[point] - 1; //나와 동생 위치가 같다면
            if (point + 1 <= 100000 && visit[point + 1] == 0) {
                visit[point + 1] = visit[point] + 1;
                queue.offer(point + 1);
            }
            if (point - 1 >= 0 && visit[point - 1] == 0) {
                visit[point - 1] = visit[point] + 1;
                queue.offer(point - 1);
            }
            if(point * 2 <= 100000 && visit[point * 2] == 0) {
                visit[point * 2] = visit[point] + 1;
                queue.offer(point * 2);
            }
        }

        return -1;
    }
}
