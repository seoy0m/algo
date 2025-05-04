class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        String[] arr = new String[signs.length];
        for(int i =0; i<signs.length; i++){
            if(signs[i]){
                arr[i]= String.valueOf(absolutes[i]);
            } else{
                arr[i]= "-" + String.valueOf(absolutes[i]);
            }
        }
        int answer = 0;
        for(int i =0; i<arr.length; i++){
            answer+= Integer.parseInt(arr[i]);
        }
        return answer;
    }
}