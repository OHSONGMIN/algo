package class3;

import java.util.*;

public class Q16928_3 {
    static Queue<Integer> queue = new LinkedList<>();//큐
    static Map<Integer, Integer> map = new HashMap<>();//뱀과 사다리
    static int[] count;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N + M; i++) {
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

            for (int i = 0; i < 6; i++) { //주사위 1~6
                int newN = num + (i + 1);

                if (check(newN)) continue; //100 초과라면
                if (visit[newN]) continue; //방문한 적 있다면
                visit[newN] = true;

                //뱀과 사다리에 포함되어있다면
                if (map.containsKey(newN)) {
                    //목적지에 도달한 적 없다면
                    if (!visit[map.get(newN)]) {
                        queue.offer(map.get(newN)); //목적지를 queue에 담는다
                        visit[map.get(newN)] = true;
                        count[newN] = count[map.get(newN)] = count[num] + 1;

                    }
                    //목적지에 도달한 적 있다면 -> 목적지로 항상 이동해야하지만 queue엔 담지 않는다 (이미 간 적 있기 때문에)
                    else {
                        count[newN] = count[num] + 1;
                    }
                }
                //일반 숫자라면
                else {
                    queue.offer(newN);
                    count[newN] = count[num] + 1;
                }
            }

        }
    }

    private static boolean check(int newN) {
        if (newN > 100) return true;
        else return false;
    }
}
