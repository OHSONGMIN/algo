package class4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549_4 {
    static int[] arr;
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //수빈이 위치
        K = sc.nextInt(); //동생 위치

        arr = new int[100001];

        Queue<Node> queue = new LinkedList<>();
        arr[N] = 1;
        queue.offer(new Node(N, 1));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

//          이렇게 쓰면 틀림
//            if(node.idx==k) {
//                visited[node.idx] = node.time;
//                System.out.println(node.time-1);
//                break; 나는 별로 이해 안되지만 ^^
//            }

            if (isCheck(node.idx * 2)) {
                if (arr[node.idx * 2] == 0 || arr[node.idx * 2] > node.time) {
                    arr[node.idx * 2] = node.time;
                    queue.offer(new Node(node.idx * 2, node.time));
                }
            }

            if (isCheck(node.idx + 1)) {
                if (arr[node.idx + 1] == 0 || arr[node.idx + 1] > node.time + 1) {
                    arr[node.idx + 1] = node.time + 1;
                    queue.offer(new Node(node.idx + 1, node.time + 1));
                }
            }

            if (isCheck(node.idx - 1)) {
                if (arr[node.idx - 1] == 0 || arr[node.idx - 1] > node.time + 1) {
                    arr[node.idx - 1] = node.time + 1;
                    queue.offer(new Node(node.idx - 1, node.time + 1));
                }
            }
        }
        System.out.println(arr[K] - 1);

    }

    private static boolean isCheck(int i) {

        if (i >= 0 && i <= 100000) return true;
        else return false;
    }

    static class Node {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
