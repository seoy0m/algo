import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int n = tangerine.length;
        int[] cnt= new int[10000000+1];
        
        for(int i=0; i<n; i++){
            cnt[tangerine[i]]++;
        }
        
        Arrays.sort(cnt);
        
        for(int i= cnt.length; i>=0; i--){
            k-=cnt[i-1];
            answer++;
            if(k<=0) break;
        }
        return answer;
    }
}