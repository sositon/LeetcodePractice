import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

import static java.lang.Math.abs;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        // helper functions
        BiPredicate<Integer, Integer> shouldCollide = (a, b) -> a > 0 && b < 0;
        BinaryOperator<Integer> collision = (a, b) -> abs(a) == abs(b) ? 0 : abs(a) > abs(b) ? a : b;

        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.empty() && shouldCollide.test(stack.peek(), asteroid)) {
                asteroid = collision.apply(stack.pop(), asteroid);
            }
            if (asteroid == 0) continue;
            stack.push(asteroid);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();

        // test case
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result));

        // another test case
        int[] asteroids2 = {8, -8};
        int[] result2 = asteroidCollision.asteroidCollision(asteroids2);
        System.out.println(Arrays.toString(result2));

        // another test case
        int[] asteroids3 = {10, 2, -5};
        int[] result3 = asteroidCollision.asteroidCollision(asteroids3);
        System.out.println(Arrays.toString(result3));
    }

}

