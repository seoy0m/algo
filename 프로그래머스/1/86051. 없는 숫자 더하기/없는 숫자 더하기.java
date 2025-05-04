import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int n : numbers) list.add(n);

        int answer = 0;
        for(int i =1; i<10; i++){
            if(!list.contains(i)){
                answer+= i;
            }
        }
        return answer;
    }
}