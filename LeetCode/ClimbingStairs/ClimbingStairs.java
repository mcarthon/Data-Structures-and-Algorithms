import java.util.HashMap;

public class ClimbingStairs {

    public int climbStairs ( int n ) {

        return helper ( n, new HashMap<Integer, Integer>() );

    }

    public int helper ( int n, HashMap<Integer, Integer> cache ) {

        if ( cache.containsKey ( n ) ) {

            return cache.get(n);

        }

        if ( n < 2 ) {

            return 1;

        }

        int total = helper ( n - 1, cache ) + helper ( n - 2, cache );

        cache.put ( n, total );

        return total;

    }

}