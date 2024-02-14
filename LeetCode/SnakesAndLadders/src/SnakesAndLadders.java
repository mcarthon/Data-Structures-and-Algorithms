import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public static void main ( String [] args ) {

        int[][] board = { { -1, -1 }, { -1, 3 } };

        int[][] board1 = {
                           {-1,-1,-1,-1,-1,-1},
                           {-1,-1,-1,-1,-1,-1},
                           {-1,-1,-1,-1,-1,-1},
                           {-1,35,-1,-1,13,-1},
                           {-1,-1,-1,-1,-1,-1},
                           {-1,15,-1,-1,-1,-1}
        };

        SnakesAndLadders sl = new SnakesAndLadders();

        System.out.println ( sl.snakesAndLadders ( board1 ) );

    }

    public int snakesAndLadders ( int[][] board ) {

        int n = board.length;

        int[] flatBoard = flattenBoard ( n, board );

        int[][] graph = createGraph ( n, flatBoard );

        int[] distance = new int [ n * n + 1 ];

        Arrays.fill ( distance, -1 );

        distance [ 1 ] = 0;

        return bfs ( 1, n, distance, graph );

    }

    public int bfs ( int source, int n, int[] distance, int[][] graph ) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add ( source );

        int destination = (n * n);

        while ( !queue.isEmpty() ) {

            int node = queue.poll();

            for ( int neighborIndex = 1; neighborIndex < 7; ++ neighborIndex ) {

                int neighbor = graph [ node ] [ neighborIndex ];

                if ( distance [ neighbor ] == -1 ) {

                    distance [ neighbor ] = distance [ node ] + 1;

                    queue.add  ( neighbor );

                }

                if ( distance [ destination ] != -1 ) {

                    return distance [ destination ];

                }

            }

        }

        return distance [ destination ];

    }

    public int[] flattenBoard ( int n, int[][] board ) {

        int[] result = new int [ n * n + 1 ];

        int index = 1;

        int iteration = 1;

        for ( int row = n - 1; row > -1; -- row ) {

            if ( iteration ++ % 2 == 1 ) {

                for ( int column = 0; column < n; ++ column ) {

                    result [ index ] = board [ row ] [ column ] != -1 ? board [ row ] [ column ] : index;

                    index ++;

                }

            }

            else {

                for ( int column = n - 1; column > -1; -- column ) {

                    result [ index ] = board [ row ] [ column ] != -1 ? board [ row ] [ column ] : index;

                    index ++;

                }

            }


        }

        return result;

    }

    public int[][] createGraph ( int n, int[] flatBoard ) {

        int numNodes = n * n + 1;

        int[][] graph = new int [ numNodes ] [ 7 ];

        for ( int node = 1; node <= numNodes; ++ node ) {

            for ( int diceRoll = 1; diceRoll <= 6; ++ diceRoll ) {

                if ( node + diceRoll <= n * n ) {

                    graph [ node ] [ diceRoll ] = flatBoard [ node + diceRoll ];

                }


            }

        }

        return graph;

    }

}