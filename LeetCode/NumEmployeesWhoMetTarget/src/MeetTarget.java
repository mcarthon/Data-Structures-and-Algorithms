import java.util.Arrays;

public class MeetTarget {

    static int metTarget ( int[] hours, int target) {

        return (int) Arrays.stream(hours).filter(element -> element >= target).count();

    }

}