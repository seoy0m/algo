class Solution {
    public int solution(long num) {
        int answer = -1;
        if(num==1){
            return 0;
        }
        for(int i =0; i<500; i++){
            if(num%2==0){
                num/=2;
            } else{
                num= num*3+1;
            }
            System.out.println(i+1+" "+ num);
            if(num==1) {
                answer=i+1;
                break;
            }
        }
        return answer;
    }
}