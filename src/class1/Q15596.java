package class1;

public class Q15596 {
    long sum(int[] a) { //int[]을 파라미터로 받는 sum 함수는 만드는 것
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }
}

