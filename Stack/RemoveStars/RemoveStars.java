import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '*' && !stack.empty()){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveStars removeStars = new RemoveStars();

        // test case
        String s = "ab**cd";
        String result = removeStars.removeStars(s);
        System.out.println(result);

        // another test case
        String s2 = "ab*cd";
        String result2 = removeStars.removeStars(s2);
        System.out.println(result2);

        // another test case
        String s3 = "ab**cd**";
        String result3 = removeStars.removeStars(s3);
        System.out.println(result3);
    }
}
