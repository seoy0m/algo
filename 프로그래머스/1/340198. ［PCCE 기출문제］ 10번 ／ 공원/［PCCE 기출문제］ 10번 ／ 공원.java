import java.util.*;

class Solution {
    static int answer = 0;
    static int n;
    
    public int solution(int[] mats, String[][] park) {
        
        answer = 0;
        n = mats.length;
        Arrays.sort(mats);
        out: for(int i =0; i< park.length; i++){
            for(int j =0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    chk(i,j,mats,park);
                }
                if(answer == mats[n-1]){
                    return answer;
                }
            }
        }
        
        return (answer == 0) ? -1 : answer;
    }
    
    static void chk(int y , int x , int[] mats, String[][] arr){
        for(int k=n-1; k>=0 ; k--){
            int t = mats[k];
            
            if(y+t> arr.length|| x+t> arr[0].length ) continue;
            
            boolean ok = true;
            
            out: for(int i=y; i<y+t; i++){
                for(int j=x; j<x+t; j++){
                    if (!arr[i][j].equals("-1")) {
                        ok = false;
                        break out; // 이 t는 실패 → 다음 t
                    }
                }
            }
            
            if (ok) {
                answer = Math.max(answer, t);  // 가장 큰 것부터 내려오므로 발견 즉시 확정
                return;      // 이 시작점에서는 더 볼 필요 없음
            }
        }
    }
}