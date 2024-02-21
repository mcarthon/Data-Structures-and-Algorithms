import java.util.Arrays;

public class FloodFill {

    public static void main ( String [] args ) {

        FloodFill fl = new FloodFill();

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};

        System.out.println (Arrays.deepToString(fl.floodFill(image, 1, 1, 2)));

    }

    public int[][] floodFill ( int[][] image, int sr, int sc, int color ) {

        int sourceColor = image[sr][sc];

        if ( sourceColor == color ) {

            return image;

        }

        this.dfs ( sr, sc, sourceColor, color, image );

        return image;

    }

    public void dfs ( int currentRow, int currentColumn, int sourceColor, int color, int[][] image ) {

        boolean outOfBounds = currentRow < 0 || currentRow == image.length
                || currentColumn < 0 || currentColumn == image[0].length;

        if ( outOfBounds ) {

            return;

        }

        image [ currentRow ] [ currentColumn ] = color;

        if ( currentRow - 1 > -1 &&
                image[currentRow - 1][currentColumn] == sourceColor ) {

            this.dfs ( currentRow - 1, currentColumn, sourceColor, color, image );

        }

        if ( currentRow + 1 < image.length &&
                image[currentRow + 1][currentColumn] == sourceColor ) {

            this.dfs ( currentRow + 1, currentColumn, sourceColor, color, image );

        }

        if ( currentColumn - 1 > -1 &&
                image[currentRow][currentColumn - 1] == sourceColor ) {

            this.dfs ( currentRow, currentColumn - 1, sourceColor, color, image );

        }

        if ( currentColumn + 1 < image[0].length &&
                image[currentRow][currentColumn + 1] == sourceColor ) {

            this.dfs ( currentRow, currentColumn + 1, sourceColor, color, image );

        }


    }

}