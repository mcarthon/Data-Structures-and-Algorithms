public class BinaryRepresentation {

    public static void main ( String [] args ) {

        BinaryRepresentation br = new BinaryRepresentation ();

        System.out.println ( br.convertToBinary ( 6 ) );

    }

    public int convertToBinary ( int n ) {

        int power = 0;

        int twoRaisedToPower = (int) Math.pow ( 2, power );

        while ( twoRaisedToPower <= n ) {

            twoRaisedToPower = (int) Math.pow ( 2, ++ power );

        }

        power --;

        int remainingValue = n;

        int result = 0;

        while ( remainingValue > 0 ) {

            twoRaisedToPower = (int) Math.pow ( 2, power );

            if ( remainingValue - twoRaisedToPower >= 0 ) {

                result += (int) Math.pow ( 10, power );

                remainingValue -= twoRaisedToPower;

            }

            power --;

        }

        return result;

    }

}