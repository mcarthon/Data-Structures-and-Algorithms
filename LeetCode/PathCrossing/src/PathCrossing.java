import java.util.HashMap;

public class PathCrossing {

    public static void main ( String [] args ) {

        System.out.println ( isPathCrossing ( "NESWW" ) );

    }

    static boolean isPathCrossing ( String path ) {

        Integer [] xyCoordinates = {0,0};

        HashMap<String, Integer> locationFrequency = new HashMap<String, Integer>();
        
        locationFrequency.put ( stringify(xyCoordinates), 1);

        return helper ( locationFrequency, path, xyCoordinates, 0 );

    }
    
    static boolean helper ( HashMap<String, Integer> locationFrequency,
                            String path,
                            Integer[] currentLocation,
                            int currentIndex) {

        if ( locationFrequency.get ( stringify(currentLocation) ) > 1 ) {

            return true;

        }

        if ( currentIndex == path.length() ) {

            return false;

        }

        Integer[] newLocation = movement ( path.charAt ( currentIndex ), currentLocation);

        locationFrequency.put ( stringify(newLocation), locationFrequency.getOrDefault ( stringify(newLocation), 0 ) + 1 );

        return helper ( locationFrequency, path, newLocation, currentIndex + 1 );

    }

    static Integer[] movement ( char direction, Integer[] coordinates ) {

        switch ( direction ) {

            case 'N':

                coordinates[1] ++;

                break;

            case 'S':

                coordinates[1] --;

                break;

            case 'E':

                coordinates[0] ++;

                break;

            case 'W':

                coordinates[0] --;

                break;

        }

        return coordinates.clone();

    }

    static String stringify ( Integer[] coordinates ) {

        return String.format ( "(%d,%d)", coordinates[0], coordinates[1] );

    }

}