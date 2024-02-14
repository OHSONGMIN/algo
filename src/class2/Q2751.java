package class2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; //배열을 만든다.
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //만든 배열을 반으로 나눈 뒤 정렬 후 합친 int[]을 return 받는다.
        Merge_Sort(arr, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
        /* 2. Collection.sort(List)를 이용할 경우 - 1560ms */
        /*
        List list = new ArrayList<Integer>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list); //오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb);
        */

        /* 1. Arrays.sort(Integer)를 이용할 경우  - 1596ms */
        /*
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
        */
    }

    private static void Merge_Sort(int[] arr, int start, int end) {
        int mid = (start + end) / 2; //중간 Idx 구하기

        //라고 하면 안된다 무한히 재귀함수가 반복될 것
        //if (arr.length == 1) return arr;

        if (start < end) {
            //다시 반으로 나누기 (재귀함수)
            Merge_Sort(arr, start, mid);
            Merge_Sort(arr, mid + 1, end);

            //정렬 후 하나로 합치고 arr에 복사하기
            Merge(arr, start, mid, end);
        }
    }

    private static void Merge(int[] arr, int start, int mid, int end) {
        int[] newArr = new int[arr.length];
        int i = start; //arr1의 startIdx
        int j = start; //newArr의 idx
        int m = mid + 1; //arr2의 startIdx
        
        while (i <= mid && m <= end) { //start가 mid를 넘지 않고 mid + 1이 end를 넘지 않을 때까지
            if (arr[i] < arr[m]) {
                newArr[j++] = arr[i++];
            } else {
                newArr[j++] = arr[m++];
            }
        }

        //만약 start가 mid를 넘거나 mid + 1이 end를 넘으면
        if (i > mid) { //i가 mid를 넘으면 m ~ end까지의 나머지 배열을 newArr 뒤에 붙인다.
            for (int k = m; k <= end; k++) {
                newArr[j++] = arr[k];
            }
        } else { //m이 end를 넘으면 i ~ mid까지의 나머지 배열을 newArr 뒤에 붙인다.
            for (int k = i; k <= mid; k++) {
                newArr[j++] = arr[k];
            }
        }

        //arr에 newArr을 복사한다.
        for (int p = 0; p < newArr.length; p++) {
            arr[p] = newArr[p];
        }
    }


}
