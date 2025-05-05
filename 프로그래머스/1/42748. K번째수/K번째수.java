import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];

            int[] copy;
            if (end == array.length) {
                copy = Arrays.copyOfRange(array, start, array.length);
            } else {
                copy = Arrays.copyOfRange(array, start, end);
            }

            Arrays.sort(copy);
            answer[i] = copy[commands[i][2] - 1];
        }
        
        return answer;
    }
}
