import java.util.ArrayList;

public class AllSubsets {

    public static void main(String[] args) {

        String s = "bird";

        System.out.println(generate_all_subsets(s));

    }

    static ArrayList<String> generate_all_subsets(String s) {

        ArrayList<String> result = new ArrayList<String>();

        return helper(result, s, 0, "");

    }

    static ArrayList<String> helper(ArrayList<String> result, String originalString, int currentIndex, String currentSubset) {

        if ( currentIndex == originalString.length() ) {

            result.add(currentSubset);

            return result;

        }

        helper ( result, originalString, currentIndex + 1, currentSubset);

        helper ( result, originalString, currentIndex + 1, currentSubset + originalString.charAt ( currentIndex ) );

        return result;

    }

}