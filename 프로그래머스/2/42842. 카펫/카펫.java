class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i = 1; i<= brown/2; i++){
            int w = (brown-2*i)/2;
            if((w-2)*i==yellow){
    
                answer[0] = w;
                answer[1] = i+2;
                break;
            }
        }
        
        
        return answer;
    }
}