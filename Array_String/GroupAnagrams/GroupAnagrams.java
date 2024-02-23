import java.util.*;
import java.util.stream.IntStream;

public class GroupAnagrams {
    private static final int EN_LETTERS = 26;

    public static List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] h = new char[EN_LETTERS];
            IntStream.range(0, s.length()).forEachOrdered(j -> h[s.charAt(j) - 'a']++);
            String key = String.valueOf(h);
            List<String> group = map.getOrDefault(key, new ArrayList<>());
            group.add(s);
            map.put(key, group);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
