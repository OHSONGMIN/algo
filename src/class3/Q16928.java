package class3;

import java.util.*;

public class Q16928 {
    static int N, M;
    static int[][] plusArr;
    static int[][] minusArr;
    static int[] game;
    static boolean[] visit;
    static Map<Integer, Integer> plusMap;
    static Map<Integer, Integer> minusMap;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        //plusArr = new int[N][2];
        //minusArr = new int[M][2];
        plusMap = new HashMap<>();
        minusMap = new HashMap<>();
        game = new int[101];
        visit = new boolean[101];

        for (int i = 0; i < N; i++) {
            //plusArr[i][0] = sc.nextInt();
            //plusArr[i][1] = sc.nextInt();
            plusMap.put(sc.nextInt(), sc.nextInt());
        }

        for (int i = N; i < N + M; i++) {
            //minusArr[i][0] = sc.nextInt();
            //minusArr[i][1] = sc.nextInt();
            minusMap.put(sc.nextInt(), sc.nextInt());
        }
        bfs();
        System.out.println(game[100]);

    }

    private static void bfs() {
        queue.offer(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int newN = num + i; //주사위를 돌린 결과

                if (newN < 101 && game[newN] == 0) { //visit은 추가할지말지고민

                    if (plusMap.containsKey(newN) && game[plusMap.get(newN)] == 0) {
                        int upNum = plusMap.get(newN);
                        game[newN] = game[upNum] = game[num] + 1;
                        queue.offer(upNum);
                    }
                    else if (minusMap.containsKey(newN) && game[minusMap.get(newN)] == 0) {
                        int downNum = minusMap.get(newN);
                        game[newN] = game[downNum] = game[num] + 1;
                        queue.offer(downNum);
                    }
                    else if (minusMap.containsKey(newN)) { //뱀num이지만 내려간 숫자는 이미 입력됨
                        game[newN] = game[num] + 1;
                    }
                    else { //뱀도 사다리도 아닌
                        game[newN] = game[num] + 1;
                        queue.offer(newN);
                    }
                }
            }
        }
    }
}
