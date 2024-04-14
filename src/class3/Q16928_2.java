package class3;

import java.util.*;

public class Q16928_2 {
    static Queue<Integer> queue = new LinkedList<>();//큐
    static Map<Integer, Integer> map = new HashMap<>();//뱀과 사다리
    static int[] count;//그래서 몇?
    static boolean[] visit;//방문했는지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }
        for (int i = 0; i < M; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }

        count = new int[101];
        visit = new boolean[101];
        bfs();

    }

    private static void bfs() {
        queue.offer(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == 100) System.out.println(count[100]);

            for (int i = 1; i <= 6; i++) {
                int newN = num + i;

                if (newN < 101 && !visit[newN]) { //방문한 적 없으면

                    //뱀or사다리 이고 이동되는 목적지에 방문한 적이 없다면
                    if (map.containsKey(newN) && !visit[map.get(newN)]) {
                        int moveN = map.get(newN);

                        count[newN] = count[moveN] = count[num] + 1;
                        queue.offer(moveN);
                        visit[newN] = visit[moveN] = true;
                    }
                    else if (map.containsKey(newN) && visit[map.get(newN)]) { //뱀or사다리 이지만 목적지에 방문한 적 있다면
                        count[newN] = count[num] + 1;
                        visit[newN] = true;
                    }
                    else { //그리고 일반적인 번호라면
                        count[newN] = count[num] + 1;
                        queue.offer(newN);
                        visit[newN] = true;

                    }
                }
            }
        }
    }
}
