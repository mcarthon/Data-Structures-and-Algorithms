import java.util.HashMap;

public class FindTownJudge {

    public int findJudge ( int n, int[][] trust ) {

        if ( trust.length == 0 ) {

            if ( n == 1 ) {

                return n;

            }

            return -1;

        }

//      values: out-degree - in-degree
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int townJudge = trust [ 0 ] [ 0 ];

        for ( int[] edge: trust ) {

            int start = edge [ 0 ];

            int target = edge [ 1 ];

            map.put ( start, map.getOrDefault ( start, 0 ) - 1 );

            map.put ( target, map.getOrDefault ( target, 0 ) + 1 );

            if ( map.get ( townJudge ) < map.get ( target) ) {

                townJudge = target;

            }

        }

        return map.get ( townJudge ) == n - 1 ? townJudge : -1;

    }

}