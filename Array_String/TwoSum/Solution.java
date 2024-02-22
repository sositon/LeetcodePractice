import java.util.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
    // We can use a hashmap to store the values and their indices
        final Map<Integer, Set<Integer>> map = new HashMap<>();
    // We can iterate through the array and store the values and their indices in the hashmap
        for (int i = 0 ; i < nums.length; i++){
            final int n = nums[i];
            final Set<Integer> indexes = map.getOrDefault(n, new HashSet<>());
            indexes.add(i);
            map.put(n, indexes);
        }
    // We can then iterate through the array and check if the difference between the target and the current value is in the hashmap
        for (int i = 0; i < nums.length; i++){
            final int n = nums[i];
            final int complement = target - n;

            if (map.containsKey(complement)){
                Set<Integer> indices = map.get(complement);
                for (int id : indices)
                    if (id != i) return new int[]{i, id};
            }
        }
    // We can return an empty array if no two values add up to the target
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        nums = new int[]{3, 3};
        target = 2;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}