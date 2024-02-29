package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<int[]> queue = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                queue.add(new int[]{ j, Integer.parseInt(st.nextToken()) });
            } //처음 위치, 중요도

            sb.append(whatNum(M, queue)).append("\n");
        }

        System.out.println(sb);
    }

    private static int whatNum(int m, LinkedList<int[]> queue) {
        //m : 처음 위치, queue.get(i)[0]가 m과 같은지 비교해야
        //queue
        int count = 1; //몇 번째로 출력되는지
                
        while (!queue.isEmpty()) {
            boolean isMax = true; //최대값인가?
            
            int i;
            for (i = 1; i < queue.size(); i++) {
                if (queue.peek()[1] < queue.get(i)[1]) {
                    isMax = false;
                    break; //최대값 아니면 걍 끝내도 됨
                }
            }

            if (isMax == false) { //결국 최대값이 아니었음
                for (int j = 0; j < i; j++) {
                    //queue.get(i)[1]가 더 크다고 했으니까 i번째 전까지 뒤로 보낸다
                    queue.add(queue.poll());
                }
                continue; //다시 시작~~
            }

            else if (isMax == true) { //최대값임 대박임
                if (queue.peek()[0] == m) { //내가 찾던 것인지
                    break;
                } else { //최대값이지만 내가 찾던 게 아님
                    queue.poll(); //빼고
                    count++; //count 세기
                }
            }
        }
        return count;
    }
}
