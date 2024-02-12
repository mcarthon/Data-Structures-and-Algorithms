public class IsGraphBipartite {

    public static void main ( String [] args ) {

        int[][] graph = { {1, 3}, { 0, 2}, {1, 3}, { 0, 2} };

        IsGraphBipartite gb = new IsGraphBipartite();

        System.out.println ( gb.isBipartite ( graph ) );

    }

    public boolean isBipartite ( int[][] graph ) {

        int n = graph.length;

        int[] level = new int [ n ];

        int[] parent = new int [ n ];

        parent [ 0 ] = -1;

        int[] visited = new int [ n ];

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            if ( !dfs ( vertex, level, parent, visited, graph ) ) {

                return false;

            }

        }

        return true;

    }

    public boolean dfs ( int currentNode, int[] level, int[] parent, int[] visited, int[][] graph ) {

        visited [ currentNode ] = 1;

        int[] adjacencyList = graph [ currentNode ];

        int length = adjacencyList.length;

        for ( int neighborIndex = 0; neighborIndex < length; ++ neighborIndex ) {

            int neighbor = adjacencyList [ neighborIndex ];

            if ( visited [ neighbor ] == 0 ) {

                visited [ neighbor ] = 1;

                level [ neighbor ] = level [ currentNode ] + 1;

                parent [ neighbor ] = currentNode;

                if ( !dfs ( neighbor, level, parent, visited, graph ) ) {

                    return false;

                }

            }

            else {

                int cycleLength = Math.abs ( level [ neighbor] - level [ currentNode ] ) + 1;

                if ( parent [ currentNode ] != neighbor && cycleLength % 2 == 1 ) {

                    return false;

                }

            }

        }

        return true;

    }

}