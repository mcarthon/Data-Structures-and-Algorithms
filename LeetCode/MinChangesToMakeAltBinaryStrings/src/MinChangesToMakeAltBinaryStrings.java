public class MinChangesToMakeAltBinaryStrings {

    static int minOperations ( String string ) {

        String alternatingString = "" + string.charAt(0);

        int index = 1;

        int altDiffCount = 0;

        while ( index < string.length() ) {

            alternatingString += alternatingString.charAt(index - 1) == '0'? '1': '0';

            altDiffCount += alternatingString.charAt(index) == string.charAt(index)? 0: 1;

            index ++;

        }

        return Math.min(altDiffCount, string.length() - altDiffCount);

    }

}