import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        int n = participant.length;
        String answer ="";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i =0; i<n ; i++){
            map.put(participant[i],map.getOrDefault(participant[i],0)+1);
        }
        
        for(int i =0; i<n-1 ; i++){
            map.put(completion[i], map.get(completion[i])-1);
        }
        
        for(String name: map.keySet()){
            if(map.get(name)==1) {
                answer= name;
            }
        }
        
        return answer;
    }
}