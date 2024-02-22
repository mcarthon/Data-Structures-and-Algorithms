import java.util.*;

public class RottingOranges {

    public List<Integer> freshOrangeIndices = new ArrayList<Integer>();

    public int orangesRotting ( int[][] grid ) {

        int maxShortestPath = 0;

        int numberOfRows = grid.length;

        int numberOfColumns = grid[0].length;

        int numberOfCells = numberOfRows * numberOfColumns;

        int [] visited = new int [ numberOfCells ];

        int [] level = new int [ numberOfCells ];

        HashMap<Integer, List<Integer>> adjacencyMap = this.createAdjacencyMap ( numberOfRows, numberOfColumns, grid );

        for ( int rottenOrange : adjacencyMap.keySet() ) {

            if ( visited [ rottenOrange ] == 0 ) {

                int result = this.bfs ( rottenOrange, level, visited, adjacencyMap );

                maxShortestPath = Math.max ( maxShortestPath, result );

            }

        }

        return maxShortestPath;

    }

    public int bfs ( int vertexID, int[] level, int[] visited, HashMap<Integer, List<Integer>> adjacencyMap ) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add ( vertexID );

        while ( !queue.isEmpty() ) {

            int node = queue.poll();

            visited [ node ] = 1;

            for ( int neighbor : adjacencyMap.get ( node ) ) {

                if ( visited [ neighbor ] == 0 ) {

                    visited [ neighbor ] = 1;

                    level [ neighbor ] = level [ node ] + 1;

                    queue.add ( neighbor );

                }

            }

        }

    }

    public HashMap<Integer, List<Integer>> createAdjacencyMap ( int numberOfRows, int numberOfColumns, int[][] grid ) {

        HashMap<Integer, List<Integer>>  adjacencyMap = new HashMap<Integer, List<Integer>> ();

        for ( int row = 0; row < numberOfRows; ++ row ) {

            for ( int column = 0; column < numberOfColumns; ++ column ) {

                int vertexID = numberOfColumns * row + column;

                if ( grid[row][column] == 2 ) {

                    List<Integer> adjacentFreshers = this.findAdjacentFreshOranges ( row, column, numberOfRows, numberOfColumns, grid );

                    adjacencyMap.put ( vertexID, adjacentFreshers );

                }

                if ( grid[row][column] == 1 ) {

                    this.freshOrangeIndices.add ( vertexID );

                }

            }

        }

        return adjacencyMap;

    }

    public List<Integer> findAdjacentFreshOranges ( int row, int column, int numberOfRows, int numberOfColumns, int[][] grid ) {

        List<Integer> adjacentFreshOranges = new ArrayList<Integer>();

        if ( row - 1 > -1 && grid[ row - 1 ][column] == 1 ) {

            int vertexID = numberOfColumns * (row - 1) + column;

            adjacentFreshOranges.add ( vertexID );

        }

        if ( row + 1 < numberOfRows && grid[ row + 1 ][column] == 1 ) {

            int vertexID = numberOfColumns * (row + 1) + column;

            adjacentFreshOranges.add ( vertexID );

        }

        if ( column - 1 > -1 && grid[ row ][ column - 1 ] == 1 ) {

            int vertexID = numberOfColumns * row + ( column - 1 );

            adjacentFreshOranges.add ( vertexID );

        }

        if ( column + 1 < numberOfColumns && grid[ row ][ column + 1 ] == 1 ) {

            int vertexID = numberOfColumns * row + ( column + 1 );

            adjacentFreshOranges.add ( vertexID );

        }

        return adjacentFreshOranges;

    }

}