import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n =numbers.length;
        String[] arr = new String[n];
        for(int i =0; i<n; i++){
            arr[i]= String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        String answer = "";
        
        if (arr[0].equals("0")) return "0";

        for (int i = 0; i < n; i++) {
            answer+=arr[i];
        }
        
        return answer;

    }
}