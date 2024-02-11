public class CountConnectedComponentsInUndirectedGraph {

    static Integer number_of_connected_components ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        int numComponent = 0;

        int[] component = new int [ n ];

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            if ( component [ vertex ] == 0 ) {

                dfs ( vertex, ++ numComponent, component, edges );

            }

        }

        return (Integer) numComponent;

    }

    static void dfs ( int currentNode, int numComponent, int [] component, ArrayList<ArrayList<Integer>> edges ) {

        component [ currentNode ] = numComponent;

        for ( ArrayList<Integer> edge : edges ) {

            int firstElement = edge.get ( 0 );

            int secondElement = edge.get ( 1 );

            if ( secondElement == currentNode && component [ firstElement ] == 0 ) {

                dfs ( firstElement, numComponent, component, edges );

            }

            if ( firstElement == currentNode && component [ secondElement ] == 0 ) {

                dfs ( secondElement, numComponent, component, edges );

            }

        }

    }

}