import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashMap<Integer,Integer> map =new HashMap<>();
        
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                map.put(numbers[i]+numbers[j],1);
            }
        }
        
        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        
        
        
        return answer;
    }
}