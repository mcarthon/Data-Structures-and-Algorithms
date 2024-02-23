import java.util.*;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland ( int[][] grid ) {

        int maxArea = 0;

        int numberOfRows = grid.length;

        int numberOfColumns = grid[0].length;

        int numberOfCells = numberOfRows * numberOfColumns;

        int [] visited = new int [ numberOfCells ];

        HashMap<Integer, List<Integer>> adjacencyMap = this.createAdjacencyMap ( numberOfRows, numberOfColumns, grid );

        for ( int landPart : adjacencyMap.keySet() ) {

            if ( visited [ landPart ] == 0 ) {

                int area = this.bfs ( landPart, visited, adjacencyMap );

                maxArea = Math.max ( maxArea, area );

            }

        }

        return maxArea;

    }

    public int bfs ( int vertexID, int[] visited, HashMap<Integer, List<Integer>> adjacencyMap ) {

        int area = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add ( vertexID );

        while ( !queue.isEmpty() ) {

            int currentNode = queue.poll();

            area ++;

            visited [ currentNode ] = 1;

            for ( int neighbor : adjacencyMap.get ( currentNode ) ) {

                if ( visited [ neighbor ] == 0 ) {

                    visited [ neighbor ] = 1;

                    queue.add ( neighbor );

                }

            }

        }

        return area;

    }

    public HashMap<Integer, List<Integer>> createAdjacencyMap ( int numberOfRows, int numberOfColumns, int[][] grid ) {

        HashMap<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

        for ( int row = 0; row < numberOfRows; ++ row ) {

            for ( int column = 0; column < numberOfColumns; ++ column ) {

                if ( grid[row][column] > 0 ) {

                    int vertexID = numberOfColumns * row + column;

                    result.put ( vertexID, this.findAdjacentSquares ( row, column, numberOfRows, numberOfColumns, grid ) );

                }

            }

        }

        return result;

    }

    public List<Integer> findAdjacentSquares ( int row, int column,int numberOfRows, int numberOfColumns, int[][] grid ) {

        List<Integer> neighbors = new ArrayList<Integer>();

        if ( row - 1 > -1 && grid [ row - 1 ] [ column ] == 1 ) {

            int vertexID = numberOfColumns * ( row - 1 ) + column;

            neighbors.add ( vertexID );

        }

        if ( row + 1 < numberOfRows && grid [ row + 1 ] [ column ] == 1 ) {

            int vertexID = numberOfColumns * ( row + 1 ) + column;

            neighbors.add ( vertexID );

        }

        if ( column - 1 > -1 && grid [ row ] [ column - 1 ] == 1 ) {

            int vertexID = numberOfColumns * row + ( column - 1 );

            neighbors.add ( vertexID );

        }

        if ( column + 1 < numberOfColumns && grid [ row ] [ column + 1 ] == 1 ) {

            int vertexID = numberOfColumns * row + ( column + 1 );

            neighbors.add ( vertexID );

        }

        return neighbors;

    }

}