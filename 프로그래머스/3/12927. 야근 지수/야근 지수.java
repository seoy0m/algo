import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> overtime = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            overtime.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            int max = (int)overtime.poll();
            if (max <= 0) break;
            overtime.offer(max - 1);
        }
        
        long answer = 0;
        while (!overtime.isEmpty()) {
            answer += Math.pow(overtime.poll(), 2);
        }
        
        return answer;
    }
    
}