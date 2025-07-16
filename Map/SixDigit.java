package Map;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int A, int B, int C, int D, int E, int F) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, A);
        map.put(2, B);
        map.put(3, C);
        map.put(4, D);
        map.put(5, E);
        map.put(6, F);

        //cond 1: check for 0 or 1 or 2 in values
        int cond = 0;
        for (int i = 1; i < 7; i++) {
            if (map.get(i) < 3) {
                cond = 1;
                break;
            }
        }
        if (cond == 0) return "Not Possible.";

        //put into array to sort
        int[] values = new int[6];
        for (int i = 1; i < 7; i++) {
            values[i-1] = map.get(i);
        }
        Arrays.sort(values);

        while (true){
            sortMap(values);
            int hours = values[0] * 10 + values[1];
            int minutes = values[2] * 10 + values[3];
            int seconds = values[4] * 10 + values[5];

            if (hours < 24 && minutes < 60 && seconds < 60) break;
        }

        //arrange the values into the map
        for (int i = 1; i < 7; i++) {
            map.put(i,values[i-1]);
        }


        String date = "" + map.get(1)+map.get(2)+":"+map.get(3)+map.get(4)+":"+map.get(5)+map.get(6);
        return date;
    }

    public int[] sortMap (int[] arr){
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) {
            Arrays.sort(arr);
            return arr;
        }
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        int start = i + 1, end = arr.length - 1;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}

public class SixDigit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 6 numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int e = input.nextInt();
        int f = input.nextInt();
        String result = solution.solution(a, b, c, d, e, f);
        System.out.println(result);
    }
}
