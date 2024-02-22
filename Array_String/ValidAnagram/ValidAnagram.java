import java.util.Arrays;

public class ValidAnagram {
    private static final int UNICODE = 160;

    public static boolean isAnagram(String s, String t){
        // Create a histogram for each String
        int[] hs = createHistogram(s);
        int[] ht = createHistogram(t);

        // Check if equal and return
        return Arrays.equals(hs, ht);
    }

    private static int[] createHistogram(String str){
        // Create histogram based in the constraint of Unicode characters
        // Initialize the histogram with 0s
        final int[] h = new int[UNICODE];
        Arrays.fill(h, 0);

        // Iterate through the string and add the occurrences of each character
        for (int i = 0; i < str.length(); i++) h[str.charAt(i)]++;
        return h;
    }

    public static void main(String[] args) {
        String s = "cat";
        String t = "rat";
        System.out.println(isAnagram(s, t));
    }
}
