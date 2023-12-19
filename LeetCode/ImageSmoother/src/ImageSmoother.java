public class ImageSmoother {

    static int[][] imageSmoother(int[][] image) {

        int numberOfRows = image.length;
        int numberOfColumns = image[0].length;

        int[][] smoothedImage = new int[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; ++row) {
            for (int column = 0; column < numberOfColumns; ++column) {
                int total = 0;
                int count = 0;
                for (int i = row - 1; i < row + 2; ++i) {
                    for (int j = column - 1; j < column + 2; ++j) {
                        if (i < 0 || i == numberOfRows || j < 0 || j == numberOfColumns) {
                            continue;
                        }
                        total += image[i][j];
                        count ++;
                    }
                }
                smoothedImage[row][column] = Math.floorDiv(total, count);
            }
        }
        return smoothedImage;
    }
}