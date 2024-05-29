import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {

    public static void main ( String[] args ) {

        int[][] relations1 = { {1,2}, {2,3}, {3,1} };

        int[][] relations2 = { {1,3}, {2,3} };

        ParallelCourses pc = new ParallelCourses ();

        System.out.println ( pc.minimumSemesters ( 3, relations1 ) );

        System.out.println ( pc.minimumSemesters ( 3, relations2 ) );

    }

    public int minimumSemesters ( int n, int[][] relations ) {

        n ++;

        List<List<Integer>> incomingEdges = this.findIncomingEdges ( relations, n );

        List<List<Integer>> outgoingEdges = this.findOutgoingEdges ( relations, n );

        return this.findNumOfSemesters ( incomingEdges, outgoingEdges, n );

    }

    public List<List<Integer>> findIncomingEdges ( int[][] edgeList, int n ) {

        List<List<Integer>> incomingEdges = new ArrayList<List<Integer>>();



        for ( int vertex = 0; vertex < n; ++ vertex ) {

            incomingEdges.add ( new ArrayList<>() );

        }

        for ( int[] edge: edgeList ) {

            incomingEdges.get ( edge [ 1 ] ).add ( edge [ 0 ] );

        }

        return incomingEdges;

    }

    public List<List<Integer>> findOutgoingEdges ( int[][] edgeList, int n ) {

        List<List<Integer>> outgoingEdges = new ArrayList<List<Integer>>();

        for ( int vertex = 0; vertex < n; ++ vertex ) {

            outgoingEdges.add ( new ArrayList<>() );

        }

        for ( int[] edge: edgeList ) {

            outgoingEdges.get ( edge [ 0 ] ).add ( edge [ 1 ] );

        }

        return outgoingEdges;

    }

    public int findNumOfSemesters ( List<List<Integer>> incomingEdges, List<List<Integer>> outgoingEdges, int n ) {

        int[] semesterTaken = new int [n];

        int[] level = new int [n];

        Queue<Integer> queue = new LinkedList<Integer>();

        int currentSemester = 1;

        int currentLevel = 1;

        for ( int vertex = 1; vertex < n; ++ vertex ) {

            if ( incomingEdges.get ( vertex ).isEmpty() ) {

                queue.add ( vertex );

                semesterTaken [ vertex ] = currentSemester;

            }

        }

        currentSemester ++;

        int lastSemester = -1;

        Queue<Integer> newQueue = new LinkedList<Integer>();

        while ( !queue.isEmpty() ) {

            int vertex = queue.poll();

            for ( int neighbor: outgoingEdges.get ( vertex ) ) {

                if ( semesterTaken [ neighbor ] == 0 ) {

                    newQueue.add ( neighbor );

                    semesterTaken [ neighbor ] = currentSemester;

                    lastSemester = currentSemester;

                    level [ vertex ] = currentLevel;

                }

                boolean cycleExists = queue.contains ( neighbor ) || level [ neighbor ] > currentLevel;

                else if ( cycleExists ) {

                    return -1;

                }

            }

            if ( queue.isEmpty() ) {

                queue.addAll ( newQueue );

                newQueue.clear();

                currentSemester ++;

            }


        }

        return lastSemester;

    }

}