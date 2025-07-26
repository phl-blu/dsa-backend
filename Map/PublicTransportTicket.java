package Map;

public class PublicTransportTicket {
    public static void main(String[] args) {
        int[] tickets = {2, 7, 25};
        int[] travel = {1,2,4,5,7,29,30};
        int costOfTickets = minCost(travel, tickets);
        System.out.println(costOfTickets);
    }

    public static int minCost(int[] travel, int[] tickets) {
        int n = travel.length;
        int[] memo = new int[n+1];
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];


        for (int i = n-1; i >= 0; i--) {
            int costDay = tickets[0] + memo[i+1];
            int j = i;
            while (j < n && travel[j] < travel[i] + 7) {
                j++;
            }
            int costWeek = tickets[1] + memo[j];

            int k = i;
            while (k < n && travel[k] < travel[i] + 30) {
                k++;
            }
            int costMonth = tickets[2] + memo[k];
            memo[i] = Math.min(costDay, Math.min(costWeek, costMonth));
        }
        return memo[0];
    }

}
