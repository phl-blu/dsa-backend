//problem 1 - 25/05
import java.util.Scanner;

class Solution {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        for (char c : binary.toCharArray()) {
            if (c == '1') {
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                counting = true;
                currentGap = 0;
            } else if (c == '0' && counting) {
                currentGap++;
            }
        }
        return maxGap;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int N;
        System.out.print("Enter a positive integer N: ");
        N = scanner.nextInt();
        int result = solution.solution(N);
        System.out.println("The longest binary gap for " + N + " is: " + result);
    }
}