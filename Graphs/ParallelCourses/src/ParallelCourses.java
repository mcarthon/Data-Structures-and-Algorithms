import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {

    public static void main ( String[] args ) {

        int[][] relations1 = { {1,2}, {2,3}, {3,1} };

        int[][] relations2 = { {1,3}, {2,3} };

        int [][] relations3 = {{5,10},{11,14},{21,22},{16,19},{21,25},{6,18},{1,9},{4,7},{10,23},{5,14},{9,18},{18,21},{11,22},{1,15},{1,2},{5,18},{7,20},{2,23},{12,13},{9,14},{10,16},{11,21},{5,12},{2,24},{8,17},{15,17},{10,13},{11,16},{20,22},{7,11},{9,15},{16,22},{18,20},{19,22},{10,18},{3,20},{16,25},{10,15},{1,23},{13,16},{23,25},{1,8},{4,10},{19,24},{11,20},{3,18},{6,25},{11,13},{13,15},{22,24},{6,24},{17,20},{2,25},{15,24},{8,21},{14,16},{5,16},{19,23},{1,5},{4,22},{19,20},{12,15},{16,18},{9,13},{13,22},{14,22},{2,8},{3,13},{9,23},{14,15},{14,17},{8,20},{9,17},{3,19},{8,25},{2,12},{7,24},{19,25},{1,13},{6,11},{14,21},{7,15},{3,14},{15,23},{10,17},{4,20},{6,14},{10,21},{2,13},{3,21},{8,11},{5,21},{6,23},{17,25},{16,21},{12,22},{1,16},{6,19},{7,25},{3,23},{11,25},{3,10},{6,7},{2,3},{5,25},{1,6},{4,17},{2,16},{13,17},{17,22},{6,13},{5,6},{4,11},{4,23},{4,8},{12,23},{7,21},{5,20},{3,24},{2,10},{13,14},{11,24},{1,3},{2,7},{7,23},{6,17},{5,17},{16,17},{8,15},{8,23},{7,17},{14,18},{16,23},{23,24},{4,12},{17,19},{5,9},{10,11},{5,23},{2,9},{1,19},{2,19},{12,20},{2,14},{11,12},{1,12},{13,23},{4,9},{7,13},{15,20},{21,24},{8,18},{9,11},{8,19},{6,22},{16,20},{22,25},{20,21},{6,16},{3,17},{1,22},{9,22},{20,24},{2,6},{9,16},{2,4},{2,20},{20,25},{9,10},{3,11},{15,18},{1,20},{3,6},{8,14},{10,22},{12,21},{7,8},{8,16},{9,20},{3,8},{15,21},{17,21},{11,18},{13,24},{17,24},{6,20},{4,15},{6,15},{3,22},{13,21},{2,22},{13,25},{9,12},{4,19},{1,24},{12,19},{5,8},{1,7},{3,16},{3,5},{12,24},{3,12},{2,17},{18,22},{4,25},{8,24},{15,19},{18,23},{1,4},{1,21},{10,24},{20,23},{4,14},{16,24},{10,20},{18,24},{1,14},{12,14},{10,12},{4,16},{5,19},{4,5},{19,21},{15,25},{1,18},{2,21},{4,24},{7,14},{4,6},{15,16},{3,7},{21,23},{1,17},{12,16},{13,18},{5,7},{9,19},{2,15},{22,23},{7,19},{17,23},{8,22},{11,17},{7,16},{8,9},{6,21},{4,21},{4,13},{14,24},{3,4},{7,18},{11,15},{5,11},{12,17},{6,9},{1,25},{12,18},{6,12},{8,10},{6,8},{11,23},{7,10},{14,25},{14,23},{12,25},{5,24},{10,19},{3,25},{7,9},{8,12},{5,22},{24,25},{13,19},{3,15},{5,15},{15,22},{10,14},{3,9},{13,20},{1,10},{9,21},{10,25},{9,24},{14,20},{9,25},{8,13},{7,12},{5,13},{6,10},{2,5},{2,18},{14,19},{1,11},{7,22},{18,25},{11,19},{18,19},{4,18},{17,18},{2,11}};

        ParallelCourses pc = new ParallelCourses ();

        System.out.println ( pc.minimumSemesters ( 3, relations1 ) );

        System.out.println ( pc.minimumSemesters ( 3, relations2 ) );

        System.out.println ( pc.minimumSemesters ( 25, relations3 ) );

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

                if ( semesterTaken [ neighbor ] == 0 && this.checkPrerequisites ( neighbor, semesterTaken, incomingEdges.get ( neighbor ) ) ) {

                    newQueue.add ( neighbor );

                    semesterTaken [ neighbor ] = currentSemester;

                    lastSemester = currentSemester;

                    level [ vertex ] = currentLevel;

                }

                else if ( semesterTaken [ neighbor ] != 0 ) {

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

    public boolean checkPrerequisites ( int vertex, int[] semesterTaken, List<Integer> incomingEdges ) {

        for ( int prerequisite: incomingEdges ) {

            if ( semesterTaken [ prerequisite ] == 0 ) {

                return false;

            }

        }

        return true;

    }

    public int dfs (  )

}