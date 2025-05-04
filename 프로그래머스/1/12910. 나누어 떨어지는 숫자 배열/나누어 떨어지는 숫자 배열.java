import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int ele : arr ){
            if(ele%divisor==0){
                list.add(ele);
            }
        
        }
        Collections.sort(list);
        int[] answer = {-1};
        
        if(list.size()>0)
            answer = new int[list.size()];
        
        for(int i =0; i<list.size(); i++){
            answer[i]=list.get(i);
            
        }
        
        
        
        return answer;
    }
}