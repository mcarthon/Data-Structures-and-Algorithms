import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow ( int rowIndex ) {

        if ( rowIndex == 0 ) {

            List<Integer> pascal = new ArrayList<Integer>();

            pascal.add (1);

            return pascal;

        }

        return helper ( rowIndex, rowIndex + 1 );

    }

    public List<Integer> helper ( int currentRow, int length ) {

        if ( currentRow == 1 ) {

            List<Integer> pascal = new ArrayList<Integer>();

            pascal.add (1);

            pascal.add (1);

            return pascal;

        }

        List<Integer> previousRow = helper ( currentRow - 1, length - 1 );

        return makeCurrentRow ( previousRow, length );

    }

    public List<Integer> makeCurrentRow ( List<Integer> previousRow, int length ) {

        List<Integer> result = new ArrayList<Integer>();

        result.add(1);

        for ( int index = 1; index < length - 1; ++ index ) {

            int number = previousRow.get(index - 1) + previousRow.get(index);

            result.add(number);

        }

        result.add(1);

        return result;

    }

}