class Solution {
    public int solution(String t, String p) {
        int n = t.length();
        int m = p.length();
        
        long P = Long.parseLong(p);
        
        int answer = 0;
        
        for(int i =0; i<= n-m; i++){
            String str = t.substring(i,i+m);
            long s = Long.parseLong(str);
            
            if(s<=P) answer++;
        }
        return answer;
    }
}