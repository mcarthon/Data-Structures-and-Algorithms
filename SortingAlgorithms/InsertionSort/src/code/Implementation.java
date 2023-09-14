package code;

import java.util.ArrayList;

public class Implementation {
	

    static ArrayList<Integer> insertion_sort(ArrayList<Integer> arr) {
        
        for ( int i = 0; i < arr.size() - 1; ++ i ) {
            
            int j = i + 1;
            
            int temp = arr.get ( j );
            
            while ( j > 0 && ( arr.get ( j - 1 ) > temp ) ) {
                
                arr.set ( j, arr.get ( j - 1 ) );
                
                j --;
                
            }
            
            arr.set ( j, temp );
            
        }
        
        return arr;
    }


}