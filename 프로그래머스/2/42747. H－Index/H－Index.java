import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        int answer=0;
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i;           // 이 위치에서 '이상' 개수
            
            if (citations[i] >= h) { // h편 이상이 h번 이상 인용
                return h;
            }
        }
        
        return answer;
    }
}