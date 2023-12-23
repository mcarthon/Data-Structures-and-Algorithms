import java.util.LinkedList;

public class NumberOfStudentsUnableToEatLunch {

    public static void main ( String [] args ) {

        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};

        System.out.println(countStudents(students, sandwiches));

    }

    static int countStudents ( int[] students, int[] sandwiches ) {

        LinkedList<Integer> studentsQueue = new LinkedList<Integer>();

        LinkedList<Integer> sandwichesQueue = new LinkedList<Integer>();

        for ( int index = 0; index < students.length; ++ index ) {

            studentsQueue.addLast(students[index]);

            sandwichesQueue.addLast(sandwiches[index]);

        }

        int iteration = 0;

        while ( iteration < studentsQueue.size() ) {

            if ( studentsQueue.peek() == sandwichesQueue.peek() ) {

                studentsQueue.poll();

                sandwichesQueue.poll();

                iteration = 0;

            }

            else {

                studentsQueue.addLast(studentsQueue.poll());

                iteration ++;

            }

        }

        return studentsQueue.size();

    }

}