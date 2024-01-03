public class RichestCustomerWealth {

    static int maximumWealth ( int[][] accounts ) {

        int maxWealth = 0;

        for ( int customer = 0; customer < accounts.length; ++ customer ) {

            int currentWealth = 0;

            for ( int bank = 0; bank < accounts[0].length; ++ bank ) {

                currentWealth += accounts[customer][bank];

            }

            maxWealth = Math.max ( maxWealth, currentWealth );

        }

        return maxWealth;

    }

}