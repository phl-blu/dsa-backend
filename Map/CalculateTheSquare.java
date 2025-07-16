package Map;

import java.util.Scanner;

class Solution {
    public static int solution(int A, int B) {
        int maxOperations = 0;

        for (int i = A; i <= B; i++) {
            int current = i;
            int operationCount = 0;

            while (true) {
                int sqrt = (int) Math.sqrt(current);
                if (sqrt * sqrt == current) {
                    current = sqrt;
                    operationCount++;
                } else {
                    break;
                }
            }

            maxOperations = Math.max(maxOperations, operationCount);
        }

        return maxOperations;
    }
}

public class CalculateTheSquare {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       System.out.println("enter 2 numbers");
       int A = input.nextInt();
       int B = input.nextInt();
       Solution solution = new Solution();
       System.out.println(solution.solution(A,B));
    }
}
