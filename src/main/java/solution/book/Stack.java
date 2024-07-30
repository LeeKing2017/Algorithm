package solution.book;

import java.util.ArrayList;
import java.util.HashMap;

public class Stack {
    public static int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        int n = s.length();
        int answer = 0;
        s += s;

        int[] ints = new int[3];
        ArrayList<Integer> integers = new ArrayList<>();

        A : for(int i = 0;i < n; i++) {
            java.util.Stack<Character> stack = new java.util.Stack<>();

            for(int j = i;j < n + 1;j++) {
                char ch = s.charAt(j);

                if (!map.containsKey(ch)) {
                    stack.add(s.charAt(j));
                } else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(ch))) {
                        continue A;
                    }
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}