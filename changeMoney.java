class GreedyChange {
    public static int changeMoney(int money) {
        int[] currency = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int count = 0;

        for (int i = 0; i < currency.length; i++) {
            int coin = currency[i];
            if (money >= coin) {
                int numCoins = money / coin;
                count += numCoins;
                money -= numCoins * coin;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(changeMoney(100));
        System.out.println(changeMoney(1000));
        System.out.println(changeMoney(750));
        System.out.println(changeMoney(25));
    }
}