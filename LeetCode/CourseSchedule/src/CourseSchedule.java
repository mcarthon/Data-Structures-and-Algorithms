public class CourseSchedule {

    public static void main ( String [] args ) {

        int[][] prerequisites = { { 1, 0 } };

        CourseSchedule cs = new CourseSchedule();

        System.out.println ( cs.canFinish ( 2, prerequisites ) );

    }

    public int currentTime = 0;

    public boolean canFinish ( int numCourses, int[][] prerequisites ) {

        int[] arrivalTime = new int [ numCourses ];

        int[] departureTime = new int [ numCourses ];

        for ( int course = 0; course < numCourses; ++ course ) {

            if ( arrivalTime [ course ] == 0 ) {

                if ( !this.dfs ( course, arrivalTime, departureTime, prerequisites ) ) {

                    return false;

                }

            }

        }

        return true;

    }

    public boolean dfs ( int currentCourse, int[] arrivalTime, int[] departureTime, int[][] prerequisites ) {

        arrivalTime [ currentCourse ] = currentTime + 1;

        for ( int[] prerequisite : prerequisites ) {

            int futureCourse = prerequisite [ 0 ];

            int neededCourse = prerequisite [ 1 ];

            if ( neededCourse == currentCourse ) {

                if ( arrivalTime [ futureCourse ] == 0 ) {

                    if ( !this.dfs ( futureCourse, arrivalTime, departureTime, prerequisites ) ) {

                        return false;

                    }

                }

                else {

                    if ( departureTime [ futureCourse ] == 0 ) {

                        return false;

                    }

                }

            }

        }

        departureTime [ currentCourse ] = this.currentTime + 1;

        return true;

    }

}