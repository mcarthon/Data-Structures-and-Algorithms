import java.util.ArrayList;

public class DFSTraversalOfGraph {

    public static void main ( String [] args ) {

        int n = 6;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> edge0 = createEdge ( 0, 1 );
        ArrayList<Integer> edge1 = createEdge ( 0, 2 );
        ArrayList<Integer> edge2 = createEdge ( 1, 4 );
        ArrayList<Integer> edge3 = createEdge ( 3, 5 );
        edges.add ( edge0 );
        edges.add ( edge1 );
        edges.add ( edge2 );
        edges.add ( edge3 );

        System.out.println ( dfs_traversal ( n, edges ) );

    }

    static ArrayList<Integer> dfs_traversal ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        if ( edges.isEmpty() ) {

            return graphWithNoEdges ( n );

        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        int [] visited = new int [ n ];

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            if ( visited [ vertex ] == 0 ) {

               helper ( vertex, edges, visited, result );

            }

        }

        return result;

    }

    static ArrayList<Integer> helper ( Integer currentNode,
                                       ArrayList<ArrayList<Integer>> edges,
                                       int [] visited,
                                       ArrayList<Integer> result ) {

        visited [ currentNode ] = 1;

        result.add ( currentNode );

        for ( ArrayList<Integer> edge : edges ) {

            Integer firstElement = edge.get ( 0 );

            Integer secondElement = edge.get ( 1 );

            if ( firstElement == currentNode && visited [ secondElement ] == 0  ) {

                helper ( secondElement, edges, visited, result );

            }

            if ( secondElement == currentNode && visited [ firstElement ] == 0  ) {

                helper ( firstElement, edges, visited, result );

            }

        }

        return result;

    }

    static ArrayList<Integer> graphWithNoEdges ( Integer n ) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            result.add ( vertex );

        }

        return result;

    }

    static ArrayList<Integer> createEdge ( int vertex1, int vertex2 ) {

        ArrayList<Integer> edge = new ArrayList<Integer>();

        edge.add ( vertex1 );

        edge.add ( vertex2 );

        return edge;

    }

}