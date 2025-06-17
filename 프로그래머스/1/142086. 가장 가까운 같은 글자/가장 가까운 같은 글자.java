import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] arr = new int[s.length()];
        HashMap<Character, Integer> map= new HashMap<>();

        arr[0]=-1;
        map.put(s.charAt(0),0);
        
        for(int i =1; i< s.length(); i++){
            if(map.getOrDefault(s.charAt(i),-1)==-1){
                arr[i]=-1;
            } 
            else{
               arr[i]= i-map.get(s.charAt(i)) ;
            }
            
            map.put(s.charAt(i),i);
        }
        
        return arr;
        
    }
}