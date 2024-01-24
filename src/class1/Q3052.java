package class1;

import java.util.*;

public class Q3052 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> numbers = new HashSet<Integer>();

        for(int i = 0; i < 10; i++) {
            numbers.add(sc.nextInt()%42);
        }

        System.out.println(numbers.size());

    }
}
