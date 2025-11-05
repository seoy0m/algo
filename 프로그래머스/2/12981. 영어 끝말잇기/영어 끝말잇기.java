import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        HashMap<String,Integer> map = new HashMap<>();
        map.put(words[0],1);

        for(int i =1; i< words.length; i++){
            if(map.getOrDefault(words[i],0)==0 
               && words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)){
                map.put(words[i],1);
            } else {
                answer[0]=i%n+1;
                
                if((i+1)%n==0) answer[1]=(i+1)/n;
                else answer[1]=(i+1)/n +1;
                
                break;
            }
        }

        return answer;
    }
}