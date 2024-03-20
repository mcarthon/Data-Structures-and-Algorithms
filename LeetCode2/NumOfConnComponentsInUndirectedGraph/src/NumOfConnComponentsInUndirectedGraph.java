public class NumOfConnComponentsInUndirectedGraph {

    public int countComponents ( int n, int[][] edges ) {

        int[] component = new int [n];

        int numComponent = 0;

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            if ( component [ vertex ] == 0 ) {

                dfs ( vertex, ++ numComponent, component, edges );

            }

        }

        return numComponent;

    }

    public void dfs ( int currentNode, int numComponent, int[] component, int[][] edges ) {

        component [ currentNode ] = numComponent;
        
        for ( int[] edge : edges ) {
            
            int firstElement = edge [ 0 ];

            int secondElement = edge [ 1 ];
            
            if ( firstElement == currentNode && component [ secondElement ] == 0 ) {
                
                dfs ( secondElement, numComponent, component, edges );
                
            }

            if ( secondElement == currentNode && component [ firstElement ] == 0 ) {

                dfs ( firstElement, numComponent, component, edges );

            }
            
        }

    }

}
