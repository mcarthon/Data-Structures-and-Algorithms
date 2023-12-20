import java.util.Arrays;

public class BuyTwoChocolates {

    public static void main ( String [] args ) {

       int[] prices = {98,54,6,34,66,63,52,39};

       int money = 62;

       System.out.println(buyChocolates(prices, money));

    }

    static int buyChocolates ( int[] prices, int money ) {

        Arrays.sort(prices);

        int sum = prices [ 0 ] + prices [ 1 ];

        return sum > money? money : money - sum;

    }

}