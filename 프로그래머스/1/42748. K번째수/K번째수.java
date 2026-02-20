import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for(int i =0; i< n; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            List<Integer> list = new ArrayList<>();
            for(int j = start-1; j< end; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i]=list.get(k-1);
        }
        return answer;
    }
}