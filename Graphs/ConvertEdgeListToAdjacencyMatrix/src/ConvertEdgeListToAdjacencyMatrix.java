import java.util.ArrayList;

public class ConvertEdgeListToAdjacencyMatrix {

    static ArrayList<ArrayList<Boolean>> convert_edge_list_to_adjacency_matrix ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        ArrayList<ArrayList<Boolean>> adjacencyMatrix = allFalse ( n );

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            for ( ArrayList<Integer> edge : edges ) {

                if ( edge.get ( 0 ) == vertex ) {

                    adjacencyMatrix.get ( vertex ).set ( edge.get ( 1 ), true );

                }

                else if ( edge.get ( 1 ) == vertex ) {

                    adjacencyMatrix.get ( vertex ).set ( edge.get ( 0 ), true );

                }

            }

        }

        return adjacencyMatrix;

    }

    static ArrayList<ArrayList<Boolean>> allFalse ( int n ) {

        ArrayList<ArrayList<Boolean>> result = new ArrayList<ArrayList<Boolean>>();

        for ( int i = 0; i < n; ++ i ) {

            ArrayList<Boolean> resultRow = new ArrayList<Boolean>();

            for ( int j = 0; j < n; ++ j ) {

                resultRow.add ( false );

            }

            result.add ( resultRow );

        }

        return result;

    }

}