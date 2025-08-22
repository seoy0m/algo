import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        int answer = n/2;
        if(map.size()<n/2){
            answer = map.size();
        }
        return answer;
    }
}