import java.util.ArrayList;

public class CheckIfSumIsPossible {

    public static void main ( String[] args ) {

        ArrayList<Long> nums = new ArrayList<Long>();
        nums.add((long) -2);
        nums.add((long) 4);
        nums.add((long) 8);

//        nums.add((long) 1);

        System.out.println ( check ( nums, (long) 8 ) );

    }

    static Boolean answer = false;

    static Boolean check (ArrayList<Long> array, Long k ) {

        return helper ( 0, k, array );

    }

    static Boolean helper ( int currentIndex, Long remainingAmount, ArrayList<Long> array ) {

        if ( remainingAmount == 0 ) {

            answer = true;

            return answer;

        }

        if ( currentIndex == array.size()  ) {

            return false;

        }

        if ( helper ( currentIndex + 1, remainingAmount - array.get(currentIndex), array ) ) {

            answer = true;

            return answer;

        }

        if ( helper ( currentIndex + 1, remainingAmount, array ) ) {

            answer = true;

            return answer;

        }

        return answer;

    }


}