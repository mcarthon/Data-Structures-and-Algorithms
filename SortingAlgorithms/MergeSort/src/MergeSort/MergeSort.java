package MergeSort;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main (String[] args ) {

    ArrayList<Integer> testArray = new ArrayList<Integer> ();

    testArray.add(1);
    testArray.add(2);
    testArray.add(3);
    testArray.add(4);

    merge_sort(testArray);

    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        
        int start = 0;
        
        int end = arr.size() - 1;
        
        if ( arr.size() <= 1 ) {
            
            return arr;
            
        }
        
        int midIndex = ( start + end ) / 2;
        
        List<Integer> firstHalf = arr.subList ( start, midIndex );
        
        ArrayList<Integer> firstHalfArrayList = new ArrayList<Integer>( firstHalf );
        
        firstHalfArrayList = merge_sort ( firstHalfArrayList );
        
        List<Integer> secondHalf = arr.subList ( midIndex, end );
        
        ArrayList<Integer> secondHalfArrayList = new ArrayList<Integer>( secondHalf );
        
        secondHalfArrayList = merge_sort ( secondHalfArrayList );
        
        int i = start;
        
        int j = midIndex;
        
        ArrayList<Integer> auxArray = new ArrayList<Integer>();
        
        while ( i < midIndex && j <= end ) {
            
            if ( firstHalfArrayList.get ( i ) < secondHalfArrayList.get ( j ) ) {
                
                auxArray.add ( firstHalfArrayList.get ( i ) );
                
                i ++;
                
            }
            
            else {
                
                auxArray.add ( secondHalfArrayList.get ( j ) );
                
                j ++;
                
            }
            
        }
        
        while ( i < midIndex ) {
            
            auxArray.add ( firstHalfArrayList.get ( i ) );
            
            i ++;
            
        }
        
        while ( j <= end ) {
            
            auxArray.add ( secondHalfArrayList.get ( j ) );
            
            j ++;
            
        }
        
        return auxArray;

    }

}