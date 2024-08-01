import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class performOperations {
    public static List<Integer> performOperations1(List<Integer> arr, List<List<Integer>> operations) {
        for (List<Integer> op : operations){
            List<Integer> subList = new ArrayList<>(arr.subList(op.get(0), op.get(1)+1));
            arr.removeAll(subList);
            Collections.reverse(subList);
            arr.addAll(op.get(0), subList);
        }
        return arr;
    }
    // add main and run tests
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<List<Integer>> operations = new ArrayList<>(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 4)));
        System.out.println(performOperations1(arr, operations));
    }
}


// write me examples for the performOperations function, and write code to execute them

// Example 1
// arr = [1, 2, 3, 4, 5]
// operations = [[1, 3], [2, 4]]
// performOperations1(arr, operations) returns [1, 4, 5, 2, 3]
// Explanation:
// [1, 2, 3, 4, 5] -> [1, 4, 3, 2, 5]
// [1, 4, 3, 2, 5] -> [1, 4, 5, 2, 3]
// Therefore, the output is [1, 4, 5, 2, 3]

// now run this code to test your performOperations function











