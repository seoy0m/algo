import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++){
            if(map.getOrDefault(nums[i],0)==0){
                map.put(nums[i],1);
            } else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        
        int n = nums.length/2;
        if(n>map.size()){
            answer= map.size();
        } else {
            answer = n;
        }
        
        return answer;
    }
}