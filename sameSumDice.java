import java.util.*;

class Solution2 {
    static class Move {
        int min;
        int max;
        int id;
        Move(int min, int max, int id) {
            this.min = min;
            this.max = max;
            this.id = id;
        }
    }

    public int solution(int[] A, int[] B) {
        long sumA = 0;
        for (int a : A) {
            sumA += a;
        }
        long sumB = 0;
        for (int b : B) {
            sumB += b;
        }
        long T = sumB - sumA;
        if (T == 0) {
            return 0;
        }

        List<Move> moveList = new ArrayList<>();
        int idCounter = 0;
        for (int a : A) {
            moveList.add(new Move(1 - a, 6 - a, idCounter++));
        }
        for (int b : B) {
            moveList.add(new Move(b - 6, b - 1, idCounter++));
        }

        int n = moveList.size();
        boolean[] used = new boolean[n];
        PriorityQueue<Move> minHeap = new PriorityQueue<>(Comparator.comparingInt(m -> m.min));
        PriorityQueue<Move> maxHeap = new PriorityQueue<>((m1, m2) -> Integer.compare(m2.max, m1.max));

        for (Move move : moveList) {
            minHeap.add(move);
            maxHeap.add(move);
        }

        long currentLow = 0;
        long currentHigh = 0;
        int count = 0;

        while (count <= n) {
            if (T >= currentLow && T <= currentHigh) {
                return count;
            }
            if (count == n) {
                break;
            }
            count++;

            if (T > currentHigh) {
                Move move = null;
                while (!maxHeap.isEmpty()) {
                    move = maxHeap.poll();
                    if (!used[move.id]) {
                        break;
                    }
                    move = null;
                }
                if (move == null) {
                    break;
                }
                used[move.id] = true;
                currentLow += move.min;
                currentHigh += move.max;
            } else if (T < currentLow) {
                Move move = null;
                while (!minHeap.isEmpty()) {
                    move = minHeap.poll();
                    if (!used[move.id]) {
                        break;
                    }
                    move = null;
                }
                if (move == null) {
                    break;
                }
                used[move.id] = true;
                currentLow += move.min;
                currentHigh += move.max;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] A = {5,4,1,2,6,5};
        int[] B = {2};
        System.out.println(solution.solution(A, B));
    }
}