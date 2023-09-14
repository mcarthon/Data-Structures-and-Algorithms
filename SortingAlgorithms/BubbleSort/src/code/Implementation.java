package code;

import java.util.ArrayList;

public class Implementation {

    static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr) {
        
        for ( int i = 0; i < arr.size(); ++ i ) {
            
            for ( int j = arr.size() - 1; j > i; -- j ) {
                
                if ( arr.get ( j - 1 ) > arr.get ( j ) ) {
                    
                    int temp = arr.get ( j );
                    
                    arr.set ( j, arr.get ( j - 1 ) );
                    
                    arr.set ( j - 1, temp );
                    
                }
                
            }
            
        }
        
        return arr;
    }
	
}