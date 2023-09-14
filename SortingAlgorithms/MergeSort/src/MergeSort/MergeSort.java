package MergeSort;
import java.util.ArrayList;

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
        
        if ( arr.size() <= 1 ) {
            
            return arr;
            
        }
        
        ArrayList<Integer> firstHalfArrayList = new ArrayList<Integer>( arr.subList ( 0, arr.size() / 2 ) );
        
        ArrayList<Integer> secondHalfArrayList = new ArrayList<Integer>( arr.subList ( arr.size() / 2, arr.size() ) );
        
        firstHalfArrayList = merge_sort ( firstHalfArrayList );
        
        secondHalfArrayList = merge_sort ( secondHalfArrayList );
        
        return merge ( firstHalfArrayList, secondHalfArrayList );
        
    }
        
    static ArrayList<Integer> merge ( ArrayList<Integer> firstHalfArrayList, ArrayList<Integer> secondHalfArrayList ) {
        
        int i = 0;
        
        int j = 0;
        
        ArrayList<Integer> auxArray = new ArrayList<Integer>();
        
        while ( i < firstHalfArrayList.size() && j < secondHalfArrayList.size() ) {
            
            if ( firstHalfArrayList.get ( i ) < secondHalfArrayList.get ( j ) ) {
                
                auxArray.add ( firstHalfArrayList.get ( i ) );
                
                i ++;
                
            }
            
            else {
                
                auxArray.add ( secondHalfArrayList.get ( j ) );
                
                j ++;
                
            }
            
        }
        
        while ( i < firstHalfArrayList.size() ) {
            
            auxArray.add ( firstHalfArrayList.get ( i ) );
            
            i ++;
            
        }
        
        while ( j < secondHalfArrayList.size() ) {
            
            auxArray.add ( secondHalfArrayList.get ( j ) );
            
            j ++;
            
        }
        
        return auxArray;
        
    }

}