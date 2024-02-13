import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    public static void main ( String [] args ) {

        int[][] board = { { -1, -1 }, { -1, 3 } };

        SnakesAndLadders sl = new SnakesAndLadders();

        System.out.println ( sl.snakesAndLadders ( board ) );

    }

    public int snakesAndLadders ( int[][] board ) {

        int n = board.length;

        int[] flatBoard = flattenBoard ( n, board );

        int[][] graph = createGraph ( n, flatBoard );

        int[] distance = new int [ n * n ];

        Arrays.fill ( distance, -1 );

        distance [ 0 ] = 0;

        return bfs ( 0, n, distance, graph );

    }

    public int bfs ( int source, int n, int[] distance, int[][] graph ) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add ( source );

        int destination = (n * n) - 1;

        while ( !queue.isEmpty() ) {

            int node = queue.poll();

            for ( int neighbor : graph [ node ] ) {

                if ( distance [ neighbor ] == -1 ) {

                    distance [ neighbor ] = distance [ node ] + 1;

                    queue.add ( neighbor );

                }

                if ( neighbor == destination ) {

                    return distance [ neighbor ];

                }

            }

        }

        return distance [ destination ];

    }

    public int[] flattenBoard ( int n, int[][] board ) {

        int[] result = new int [ n * n ];

        int index = 0;

        for ( int row = n - 1; row > -1; -- row ) {

            if ( n - row % 2 == 1 ) {

                for ( int column = 0; column < n; ++ column ) {

                    result [ index ++ ] = board [ row ] [ column ];

                }

            }

            else {

                for ( int column = n - 1; column > -1; -- column ) {

                    result [ index ++ ] = board [ row ] [ column ];

                }

            }


        }

        return result;

    }

    public int[][] createGraph ( int n, int[] flatBoard ) {

        int[][] graph = new int [ n * n ] [ 6 ];

        for ( int node = 0; node <= n; ++ node ) {

            for ( int diceRoll = 0; diceRoll <= 5; ++ diceRoll ) {

                if ( node + diceRoll + 1 < n * n ) {

                    graph [ node ] [ diceRoll ] = flatBoard [ node + diceRoll + 1 ];

                }


            }

        }

        return graph;

    }

}