package class2;

import java.util.*;

public class Q2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Queue queue = new LinkedList();

        for (int i = 1; i <= num; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());




/* ArrayList 짱 오래 걸림 */
/* num은이 최대 50만개인데 50만개를 복사할거니? 아니 */
        /*
        List list = new ArrayList();

        for (int i = 1; i <= num; i++) {
            list.add(i);
        }

        for (int i = 1; i < num; i++) {
            list.remove(0);
            list.add(list.get(0));
            list.remove(0);
        }
        System.out.println(list.get(0));
        */
    }
}
