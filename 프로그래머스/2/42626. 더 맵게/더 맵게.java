import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: scoville ) pq.offer(s);
        
        int answer=0;
        
        while(!pq.isEmpty() && pq.peek()<K){
            if(pq.size()<2) return -1;
            
            int first = pq.poll();
            int second = pq.poll();
            long mixed =(long) first+ 2L* second;
            pq.offer((int)mixed);
            
            answer++;
        }
            return answer;
    }
}