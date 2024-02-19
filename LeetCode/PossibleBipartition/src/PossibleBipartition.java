public class PossibleBipartition {

    public static void main ( String [] args ) {

        int[][] dislikes = { {1,2},{1,3},{2,4} };

        PossibleBipartition pb = new PossibleBipartition();

        System.out.println ( pb.possibleBipartition ( 4, dislikes ) );

    }

    public boolean possibleBipartition ( int n, int[][] dislikes ) {

        int [] level = new int [ n + 1 ];

        int [] visited = new int [ n + 1 ];

        for ( int vertex = 1; vertex < n; ++ vertex ) {

            if ( visited [ vertex ] == 0 ) {

                if ( !this.dfs ( vertex, visited, level, dislikes ) ) {

                    return false;

                }

            }

        }

        return true;

    }

    public boolean dfs ( int vertex, int [] visited, int[] level, int[][] dislikes ) {

        visited [ vertex ] = 1;

        for ( int[] edge : dislikes ) {

            int firstVertex = edge [ 0 ];

            int secondVertex = edge [ 1 ];

            if ( firstVertex == vertex ) {

                int neighbor = secondVertex;

                if ( visited [ neighbor ] == 0 ) {

                    visited [ neighbor ] = 1;

                    level [ neighbor ] = level [ vertex ] + 1;

                    if ( !this.dfs ( neighbor, visited, level, dislikes ) ) {

                        return false;

                    }

                }

                else {

                    int cycleLength = Math.abs ( level [ neighbor ] - level [ vertex ] ) + 1;

                    if ( cycleLength % 2 == 1 ) {

                        return false;

                    }

                }

            }

            else if ( secondVertex == vertex ) {

                int neighbor = firstVertex;

                if ( visited [ neighbor ] == 0 ) {

                    visited [ neighbor ] = 1;

                    level [ neighbor ] = level [ vertex ] + 1;

                    if ( !this.dfs ( neighbor, visited, level, dislikes ) ) {

                        return false;

                    }

                }

                else {

                    int cycleLength = Math.abs ( level [ neighbor ] - level [ vertex ] ) + 1;

                    if ( cycleLength % 2 == 1 ) {

                        return false;

                    }

                }

            }

        }

        return true;

    }

}