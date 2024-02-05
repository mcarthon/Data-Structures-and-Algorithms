import java.util.ArrayList;
import java.util.Collections;

public class ConvertEdgeListToAdjacencyList {

    static ArrayList<ArrayList<Integer>> convert_edge_list_to_adjacency_list ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            ArrayList<Integer> vertexArray = new ArrayList<Integer>();

            for ( ArrayList<Integer> edge : edges ) {

                if ( edge.get ( 0 ) == vertex ) {

                    vertexArray.add ( edge.get ( 1 ) );

                }

                if ( edge.get ( 1 ) == vertex ) {

                    vertexArray.add ( edge.get ( 0 ) );

                }

            }

            Collections.sort ( vertexArray );

            adjacencyList.add ( vertexArray );

        }

        return adjacencyList;

    }

}