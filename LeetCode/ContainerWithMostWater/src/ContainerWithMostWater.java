public class ContainerWithMostWater {

    public static void main ( String [] args ) {

        int[] heights = {2,3,10,5,7,8,9};

        System.out.println ( mostWater ( heights ) );

        int[] heights1 = {1,3,2,5,25,24,5};

        System.out.println ( mostWater ( heights1 ) );

    }

    static int mostWater ( int[] heights ) {

        int left = 0;
        int right = heights.length - 1;

        int maxArea = 0;

        while ( left < right ) {

            int minHeight = Math.min(heights[left], heights[right]);

            int area = (right - left) * Math.min(heights[left], heights[right]);

            maxArea = area > maxArea? area: maxArea;

            if ( minHeight ==  heights[left] ) {

                left ++;

            }

            else {

                right --;

            }

        }

        return maxArea;

    }

}