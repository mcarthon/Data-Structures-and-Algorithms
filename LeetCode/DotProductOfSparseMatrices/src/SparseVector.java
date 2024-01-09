import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class SparseVector {

    HashMap<Integer, Integer> map;

    SparseVector(int[] nums) {

        map = new HashMap<Integer, Integer>();

        for ( int index = 0; index < nums.length; ++ index ) {

            if ( nums[index] != 0 ) {

                this.map.put(index, nums[index]);

            }

        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        Set<Integer> keys1 = this.map.keySet();
        Set<Integer> keys2 = vec.map.keySet();
        Set<Integer> intersectionKeys = new HashSet<Integer>(keys1);
        intersectionKeys.retainAll(keys2);

        int sum = 0;

        for ( Integer index: intersectionKeys ) {

            int total = this.map.get(index) * vec.map.get(index);

            sum += total;
        }

        return sum;

    }

}