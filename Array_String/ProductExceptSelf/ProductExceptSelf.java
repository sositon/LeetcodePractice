import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums){
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        int[] res = new int[nums.length];
        IntStream.range(0, nums.length).forEachOrdered(i -> res[i] = left[i] * right[i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }
}
