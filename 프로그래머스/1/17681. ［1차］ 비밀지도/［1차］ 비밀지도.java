import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i= 0; i<n ; i++){
            String binary1 = Integer.toBinaryString(arr1[i]);
            String padded1 = String.format("%" + n + "s", binary1).replace(' ', '0');

            String binary2 = Integer.toBinaryString(arr2[i]);
            String padded2 = String.format("%" + n + "s", binary2).replace(' ', '0');

            
            String now= "";
            for(int j=0; j<n; j++){
                if(padded1.charAt(j)=='1' || padded2.charAt(j)=='1'){
                    now+="#";
                } else {
                    now+=" ";
                }
            }
            
            answer[i]=now;
        }
        return answer;
    }
}