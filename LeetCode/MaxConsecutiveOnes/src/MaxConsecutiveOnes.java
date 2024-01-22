public class MaxConsecutiveOnes {

    public int maxOnes = 0;

    public int findMaxConsecutiveOnes ( int[] nums ) {

        int length = nums.length;

        return this.helper ( 0, 0, length, nums );

    }

    public int helper ( int currentIndex, int currentOnes, int length, int[] nums ) {

        if ( currentIndex == length ) {

            return this.maxOnes;

        }

        int newCurrentOnes = currentOnes;

        if ( nums [ currentIndex ] == 1 ) {

            newCurrentOnes ++;

            this.maxOnes = newCurrentOnes > this.maxOnes ? newCurrentOnes : this.maxOnes;

        }

        else {

            this.maxOnes = newCurrentOnes > this.maxOnes ? newCurrentOnes : this.maxOnes;

            newCurrentOnes = 0;

        }

        this.helper ( currentIndex + 1, newCurrentOnes, length, nums );

        return this.maxOnes;

    }

}