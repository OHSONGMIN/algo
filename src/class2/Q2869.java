package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B); //항상 A는 B보다 하나 많다.
        //따라서 각 항목에 - B를 하면서 달팽이가 하루 덜 내려갔음을 가정한다.
        //이때 나머지 값이 0이라면 마지막날 A만큼 오르면서 V에 도달한 것이고
        //0이 아니라면 하루를 더해주면 된다.
        if ((V - B) % (A - B) != 0) {
            day++;
        }

        System.out.println(day);
/* 성공 */
        /*
        double last = V - A; //여기에서 달팽이가 하루만 더 오르면 정상

        //그렇다면 last까지 올라오는 데 며칠이 걸린거지?
        double oneDay = A - B; //하루에 올라가는 길이

        int cnt = (int) Math.ceil(last / oneDay); //oneDay씩 최소 last까지 올라가려면 며칠이 걸리냐
        //이 때 올림을 해야함. 예를 들어 3 / 2라면 1.5 -> 2일이 필요함

        System.out.println(cnt + 1);

         */
    }
}
