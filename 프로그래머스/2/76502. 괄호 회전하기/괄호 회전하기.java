import java.util.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;

        Set<Character> open = new HashSet<>(Arrays.asList('(', '{', '['));
        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')'); pair.put('{', '}'); pair.put('[', ']');

        int answer = 0;

        for (int shift = 0; shift < n; shift++) {
            String rotated = s.substring(shift) + s.substring(0, shift);
            if (isValid(rotated, open, pair)) answer++;
        }
        return answer;
    }

    private boolean isValid(String str, Set<Character> open, Map<Character, Character> pair) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (open.contains(c)) {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                Character expect = pair.get(top);
                if (expect == null || expect != c) return false;
            }
        }
        return st.isEmpty();
    }
}
