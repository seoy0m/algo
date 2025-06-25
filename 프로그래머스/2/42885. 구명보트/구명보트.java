import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int n = people.length;
        
        Arrays.sort(people);
        int j=0;
        for(int i=n-1; i>=j; i--){
            if(people[i]+people[j]<=limit){
                answer++;
                j++;
            } else{
                answer++;
            }
        }
        
        return answer;
    }
}