class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = 123456789;
        int max = -123456789;
        
        for(int i =0; i<arr.length; i++){
            min = Math.min(min,Integer.parseInt(arr[i]));
            max = Math.max(max,Integer.parseInt(arr[i]));
        }
        
        String answer = "";
        answer+= min+" "+max;
        return answer;
    }
}