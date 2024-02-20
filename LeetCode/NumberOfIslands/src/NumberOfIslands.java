import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberOfIslands {

    public static void main ( String [] args ) {

        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        
        NumberOfIslands ni = new NumberOfIslands();
        
        System.out.println ( ni.numIslands ( grid ) );

    }

    public int numIslands ( char[][] grid ) {

        int numberOfRows = grid.length;

        int numberOfColumns = grid [ 0 ].length;

        int n = numberOfColumns * numberOfRows;

        HashSet<Integer> validVertices = new HashSet<Integer>();

        List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();

        int[][] directions =  { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for ( int row = 0; row < numberOfRows; ++ row ) {

            for ( int column = 0; column < numberOfColumns; ++ column ) {

                adjacencyList.add ( new ArrayList<Integer>() );

                if ( grid [ row ] [ column ] == '1' ) {

                    int vertex = row * numberOfColumns + column;

                    validVertices.add ( vertex );

                    for ( int[] direction : directions ) {

                        int rowDirection = direction [ 0 ];

                        int columnDirection = direction [ 1 ];

                        int neighborRow = row + rowDirection;

                        int neighborColumn = column + columnDirection;

                        int neighbor = neighborRow * numberOfColumns + neighborColumn;

                        boolean neighborDimensionsInBounds = neighborRow > -1 && neighborRow < numberOfRows
                                                                && neighborColumn > -1 && neighborColumn < numberOfColumns;

                        if ( neighborDimensionsInBounds && grid [ neighborRow ] [ neighborColumn ] == '1' ) {

                            adjacencyList.get ( vertex ).add ( neighbor );

                        }

                    }

                }

            }

        }

        return this.countConnectedComponents ( n, validVertices, adjacencyList );

    }

    public int countConnectedComponents ( int n, HashSet<Integer> validVertices, List<List<Integer>> adjacencyList ) {

        int numComponents = 0;

        int[] visited = new int[ n ];

        for ( int vertex : validVertices ) {

            if ( visited [ vertex ] == 0 ) {

                numComponents ++;

                this.dfs ( vertex, visited, adjacencyList );

            }

        }

        return numComponents;

    }

    public void dfs ( int currentVertex, int[] visited, List<List<Integer>> adjacencyList ) {

        visited [ currentVertex ] = 1;

        List<Integer> currentAdjList = adjacencyList.get ( currentVertex );

        for ( int neighbor: currentAdjList ) {

            if ( visited [ neighbor ] == 0 ) {

                this.dfs ( neighbor, visited, adjacencyList );
            }

        }

    }

}