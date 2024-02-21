import java.util.Arrays;
import java.util.Stack;

public class CourseScheduleII {

    public static void main ( String[] args ) {

        int[][] prerequisistes = {{0,2},{1,2},{2,0}};

        CourseScheduleII cs2 = new CourseScheduleII();

        System.out.println ( Arrays.toString ( cs2.findOrder ( 3, prerequisistes ) ) );

    }

    public int time = 0;

    public int index;

    public int[] findOrder ( int numCourses, int[][] prerequisites ) {

        this.index = numCourses - 1;

        int[] courseOrder = new int [ numCourses ];

        int[] arrivalTimes = new int [ numCourses ];

        int[] departureTimes = new int [ numCourses ];

        for ( int course = 0; course < numCourses; ++ course ) {

            if ( arrivalTimes [ course ] == 0 ) {

                courseOrder = this.dfs ( course, courseOrder, arrivalTimes, departureTimes, prerequisites );

                if ( courseOrder.length == 0 ) {

                    return courseOrder;

                }

            }

        }

        return courseOrder;

    }

    public int[] dfs ( int currentCourse, int[] courseOrder, int[] arrivalTimes, int[] departureTimes, int[][] prerequisites ) {

        arrivalTimes [ currentCourse ] = ++ this.time;

        for ( int[] prerequisite : prerequisites ) {

            int futureCourse = prerequisite [ 0 ];

            int neededCourse = prerequisite [ 1 ];

            if ( currentCourse == neededCourse ) {

                if ( arrivalTimes [ futureCourse ] == 0 ) {

                     courseOrder = this.dfs ( futureCourse, courseOrder, arrivalTimes, departureTimes, prerequisites );

                     if ( this.time != 1 && courseOrder.length == 0 ) {

                         return courseOrder;

                     }

                }

                else {

                    if ( departureTimes [ futureCourse ] == 0 ) {

                        return new int[] {};

                    }

                }

            }

        }

        departureTimes [ currentCourse ] = ++ this.time;

        courseOrder [ this.index -- ] = currentCourse;

        return courseOrder;

    }

}