import java.util.*;

public class BFSTraveralOfAGraph {

    static ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();

    static ArrayList<Integer> bfs_traversal ( Integer n, ArrayList<ArrayList<Integer>> edges ) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        createAdjacencyList ( n, edges );

        int [] captured = new int [ n ];

        int [] visited = new int [ n ];

        ArrayList<Integer> parent = new ArrayList<Integer>( Collections.nCopies ( n, null ) );

        Integer source = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add ( source );

        while ( !queue.isEmpty() ) {

            Integer vertex = queue.poll();

            result.add ( vertex );

            captured [ vertex ] = 1;

            visited [ vertex ] = 1;

            ArrayList<Integer> neighbors = adjacencyList.get ( vertex );

            for ( Integer neighbor : neighbors ) {

                if ( visited [ neighbor ] == 0 ) {

                    parent.set ( neighbor, vertex );

                    visited [ neighbor ] = 1;

                    queue.add ( neighbor );

                }

            }

        }

        for ( int i = 0; i < n; ++ i ) {

            if ( visited [ i ] == 0 ) {

                result.add ( i );

            }

        }

        return result;

    }

    static void createAdjacencyList ( int n, ArrayList<ArrayList<Integer>> edges ) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for ( int i = 0; i < n; ++ i ) {

            adjacencyList.add ( new ArrayList<Integer> () );

        }

        for ( ArrayList<Integer> edge : edges ) {

            adjacencyList.get ( edge.get ( 0 ) ).add ( edge.get ( 1 ) );

            adjacencyList.get ( edge.get ( 1 ) ).add ( edge.get ( 0 ) );

        }

    }

}