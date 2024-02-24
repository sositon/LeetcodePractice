import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k){
        // Map frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            int freq = map.getOrDefault(n, 0) + 1;
            map.put(n, freq);
        }
        // minHeap with custom comparator
        Queue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        // Keep the size of the heap no bigger than K
        for (int key : map.keySet()){
            minHeap.add(key);
            if (minHeap.size() > k) minHeap.poll();
        }
        // Heap to array
        int[] res = new int[k];
        IntStream.range(0, k).forEach(i -> res[i] = minHeap.poll());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
