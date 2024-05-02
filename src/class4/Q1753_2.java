package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753_2 {
    //우선순위큐 가중치가 낮은 순부터 오름차순으로 정렬할 것이다.
    static PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> o1.w - o2.w);
    static boolean[] visit;
    static int[] dist;
    static ArrayList<Node>[] arr;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //정점 개수
        int E = Integer.parseInt(st.nextToken()); //간선 개수
        int K = Integer.parseInt(br.readLine()); //시작점

        visit = new boolean[V+1];
        arr = new ArrayList[V+1]; //이 배열의 인덱스에는 ArrayList<Node>가 담겨있다!!

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //start
            int v = Integer.parseInt(st.nextToken()); //end
            int w = Integer.parseInt(st.nextToken()); //가중치

            arr[u].add(new Node(v, w));
        }

        dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;

        //다익스트라 알고리즘
        dijkstra(K);
    }

    private static void dijkstra(int k) {
        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visit[now.v]) continue; //방문한적 있으면

            for (int i = 0; i < arr[now.v].size(); i++) {
                //이제 now.v와 연결된 정점들을 살필 예정

                //now.v와 연결된 node의 정점을 가져온다.
                int next = arr[now.v].get(i).v;
                //now.v와 연결된 node의 가중치를 가져온다.
                int weight = arr[now.v].get(i).w;

                dist[next] = Math.min(dist[next], dist[now.v] + weight);
                pq.offer(new Node(next, dist[next]));
            }

            visit[now.v] = true;
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
