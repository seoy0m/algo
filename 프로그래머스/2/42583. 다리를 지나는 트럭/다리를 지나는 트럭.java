import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> q = new ArrayDeque<>(); // {truckWeight, exitTime}
        int time = 0, sum = 0, idx = 0;

        while (idx < truck_weights.length || !q.isEmpty()) {
            time++;

            // 1) 하차 처리(같은 초에 여러 대도 가능)
            while (!q.isEmpty() && q.peek()[1] == time) {
                sum -= q.poll()[0];
            }

            // 2) 새 트럭 투입
            if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                int w = truck_weights[idx++];
                sum += w;
                q.add(new int[]{w, time + bridge_length});
            }
        }

        return time;
    }
}
