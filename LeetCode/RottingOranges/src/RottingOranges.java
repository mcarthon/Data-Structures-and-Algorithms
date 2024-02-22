import java.util.*;

public class RottingOranges {

    public static void main ( String[] args ) {

        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        RottingOranges ro = new RottingOranges();

        System.out.println ( ro.orangesRotting ( grid ) );

    }

    public List<Integer> freshOrangeIndices = new ArrayList<Integer>();

    public int orangesRotting ( int[][] grid ) {

        int numberOfRows = grid.length;

        int numberOfColumns = grid[0].length;

        int numberOfCells = numberOfRows * numberOfColumns;

        int [] visited = new int [ numberOfCells ];

        HashMap<Integer, List<Integer>> adjacencyMap = this.createAdjacencyMap ( numberOfRows, numberOfColumns, grid );

        return this.freshOrangeIndices.isEmpty() ? 0 : this.bfs ( visited, adjacencyMap );

    }

    public int bfs ( int[] visited, HashMap<Integer, List<Integer>> adjacencyMap ) {

        int minutes = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        for ( int orange : adjacencyMap.keySet() ) {

            if ( !this.freshOrangeIndices.contains ( orange ) ) {

                queue.add ( orange );

            }

        }

        Queue<Integer> newQueue = new LinkedList<Integer>();

        while ( !queue.isEmpty() ) {

            int node = queue.poll();

            visited [ node ] = 1;

            for ( int neighbor : adjacencyMap.get ( node ) ) {

                if ( visited [ neighbor ] == 0 ) {

                    visited [ neighbor ] = 1;

                    newQueue.add ( neighbor );

                    this.freshOrangeIndices.remove ( Integer.valueOf( neighbor ) );

                    if ( this.freshOrangeIndices.isEmpty() ) {

                        return minutes + 1;

                    }

                }

            }

            if ( queue.isEmpty() ) {

                minutes ++;

                queue.addAll ( newQueue );

                newQueue.clear();

            }

        }

        return this.freshOrangeIndices.isEmpty() ? minutes : -1;

    }

    public HashMap<Integer, List<Integer>> createAdjacencyMap ( int numberOfRows, int numberOfColumns, int[][] grid ) {

        HashMap<Integer, List<Integer>>  adjacencyMap = new HashMap<Integer, List<Integer>> ();

        for ( int row = 0; row < numberOfRows; ++ row ) {

            for ( int column = 0; column < numberOfColumns; ++ column ) {

                int vertexID = numberOfColumns * row + column;

                if ( grid[row][column] > 0 ) {

                    List<Integer> adjacentOranges = this.findAdjacentOranges ( row, column, numberOfRows, numberOfColumns, grid );

                    adjacencyMap.put ( vertexID, adjacentOranges );

                }

                if ( grid[row][column] == 1 ) {

                    this.freshOrangeIndices.add ( vertexID );

                }

            }

        }

        return adjacencyMap;

    }

    public List<Integer> findAdjacentOranges ( int row, int column, int numberOfRows, int numberOfColumns, int[][] grid ) {

        List<Integer> adjacentOranges = new ArrayList<Integer>();

        if ( row - 1 > -1 && grid[ row - 1 ][column] > 0 ) {

            int vertexID = numberOfColumns * (row - 1) + column;

            adjacentOranges.add ( vertexID );

        }

        if ( row + 1 < numberOfRows && grid[ row + 1 ][column] > 0 ) {

            int vertexID = numberOfColumns * (row + 1) + column;

            adjacentOranges.add ( vertexID );

        }

        if ( column - 1 > -1 && grid[ row ][ column - 1 ] > 0 ) {

            int vertexID = numberOfColumns * row + ( column - 1 );

            adjacentOranges.add ( vertexID );

        }

        if ( column + 1 < numberOfColumns && grid[ row ][ column + 1 ] > 0 ) {

            int vertexID = numberOfColumns * row + ( column + 1 );

            adjacentOranges.add ( vertexID );

        }

        return adjacentOranges;

    }

}