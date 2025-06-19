import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        int m = discount.length;
        HashMap<String, Integer> map = new HashMap<> ();
        
        for(int i =0; i<n; i++){
            map.put(want[i],number[i]);
        }
        
        for(int i=0; i<=m-10; i++){
            HashMap<String, Integer> map2 =  new HashMap<> ();
            map2.putAll(map);
            // System.out.println(i);
            
            if(map2.get(discount[i])==null) continue;
            int cnt=1;
            map2.put(discount[i],map2.get(discount[i])-1);
            
            for(int j= i+1; j< i+10; j++){
                if(map2.get(discount[j])==null|| map2.get(discount[j])<=0) continue;
                // System.out.println(discount[i]+" "+discount[j]);
                map2.put(discount[j],map2.get(discount[j])-1);
                cnt++;
            }
            // System.out.println(i);
            if(cnt==10) answer++;
        }
        return answer;
    }
}