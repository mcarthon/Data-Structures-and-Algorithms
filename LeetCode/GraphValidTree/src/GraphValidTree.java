public class GraphValidTree {

    public boolean validTree ( int n, int[][] edges ) {

        int [] visited = new int [ n ];

        int [] parent = new int [ n ];

        parent [ 0 ] = -1;

        int numComponent = 0;

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            if ( visited [ vertex ] == 0 ) {

                if ( ++ numComponent > 1 ) {

                    return false;

                }

                if ( !dfs ( vertex, parent, visited, edges ) ) {

                    return false;

                }

            }

        }

        return true;

    }

    public boolean dfs ( int currentNode, int[] parent, int[] visited, int[][] edges ) {

        visited [ currentNode ] = 1;

        for ( int[] edge : edges ) {

            if ( currentNode == edge [ 0 ] || currentNode == edge [ 1 ] ) {

                int neighbor = currentNode == edge [ 0 ] ? edge [ 1 ] : edge [ 0 ];

                if ( visited [ neighbor ] == 0 ) {

                    parent [ neighbor ] = currentNode;

                    if ( !dfs ( neighbor, parent, visited, edges ) ) {

                        return false;

                    }

                }

                else {

                    if ( parent [ currentNode ] != neighbor ) {

                        return false;

                    }

                }

            }

        }

        return true;

    }

}