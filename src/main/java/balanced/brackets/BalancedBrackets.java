package balanced.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char bracket : s.toCharArray()) {
            if (map.containsKey(bracket)) {
                stack.push(map.get(bracket));
            } else if (map.containsValue(bracket)) {
                if (stack.isEmpty()) return false;

                char expectedClose = stack.pop();
                if (bracket != expectedClose) return false;
            }
        }
        return stack.isEmpty();
    }

}

