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

        HashSet<List<Integer>> edgeList = new HashSet<List<Integer>>();

        int[][] directions =  { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for ( int row = 0; row < numberOfRows; ++ row ) {

            for ( int column = 0; column < numberOfColumns; ++ column ) {

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

                            List<Integer> newEdge = new ArrayList<Integer>();

                            newEdge.add ( Math.min ( vertex, neighbor ) );

                            newEdge.add ( Math.max ( vertex, neighbor ) );

                            edgeList.add ( newEdge );

                        }

                    }

                }

            }

        }

        return this.countConnectedComponents ( n, validVertices, edgeList );

    }

    public int countConnectedComponents ( int n, HashSet<Integer> validVertices, HashSet<List<Integer>> edgeList ) {

        int numComponents = 0;

        List<ArrayList<Integer>> adjacencyList = this.convertEdgeListToAdjacencyList ( n, edgeList );

        int[] visited = new int[ n ];

        for ( int vertex : validVertices ) {

            if ( visited [ vertex ] == 0 ) {

                numComponents ++;

                this.dfs ( vertex, visited, adjacencyList );

            }

        }

        return numComponents;

    }

    public void dfs ( int currentVertex, int[] visited, List<ArrayList<Integer>> adjacencyList ) {

        visited [ currentVertex ] = 1;

        ArrayList<Integer> currentAdjList = adjacencyList.get ( currentVertex );

        for ( int neighbor: currentAdjList ) {

            if ( visited [ neighbor ] == 0 ) {

                this.dfs ( neighbor, visited, adjacencyList );
            }

        }

    }

    public List<ArrayList<Integer>> convertEdgeListToAdjacencyList ( int n, HashSet<List<Integer>> edgeList ) {

        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            ArrayList<Integer> adjacencyList = new ArrayList<Integer>();

            for ( List<Integer> edge: edgeList ) {

                int firstElement =  edge.get ( 0 );

                int secondElement =  edge.get ( 1 );

                if ( firstElement == vertex || secondElement == vertex ) {

                    int neighbor = firstElement == vertex ? secondElement : firstElement;

                    adjacencyList.add ( neighbor );

                }

            }

            result.add ( adjacencyList );

        }

        return result;

    }

}