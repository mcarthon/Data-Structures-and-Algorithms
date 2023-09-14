package code;

import java.util.ArrayList;

public class Implementation {
	
static ArrayList<Integer> selection_sort(ArrayList<Integer> arr) {
        
        
        for ( int i = 0; i < arr.size(); ++ i ) {
            
            int minIndex = i;
            
            for ( int j = i + 1; j < arr.size(); ++ j ) {
                
                if ( arr.get( j ) < arr.get ( minIndex ) ) {
                    
                    minIndex = j;
                    
                }
                
            }
            
            if ( minIndex != i ) {
                
                int temp  = arr.get( minIndex );
                
                arr.set ( minIndex, arr.get ( i ) );
                
                arr.set ( i, temp );
                
            }
            
        }
        
        return arr;
    }


}