public class Base7 {

    public String convertToBase7 ( int num ) {

        if ( num == 0 ) {

            return "0";

        }

        int absoluteValueNum = Math.abs ( num );

        int power = this.findHighestPower ( absoluteValueNum );

        return this.buildOutput ( absoluteValueNum, num, power );

    }

    public int findHighestPower ( int num ) {

        int power = 0;

        while ( Math.pow ( 7, power ) < num ) {

            power ++;

        }

        return Math.pow ( 7, power ) > num ? power - 1 : power;

    }

    public String buildOutput ( int absoluteValueNum, int num, int power ) {

        StringBuilder result = new StringBuilder();

        if ( num < 0 ) {

            result.append ( "-" );

        }

        int remaining = absoluteValueNum;

        while ( remaining > 0 && power > 0 ) {

            int currentNumber = (int) Math.pow ( 7, power );

            if ( currentNumber <= remaining ) {

                String nextDigit = String.format ( "%d", remaining / currentNumber );

                result.append ( nextDigit );

                remaining -= currentNumber * ( remaining / currentNumber );

            }

            else {

                result.append ( "0" );

            }

            power --;

        }

        return result.toString();

    }

}