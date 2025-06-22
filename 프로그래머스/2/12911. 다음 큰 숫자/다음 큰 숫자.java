class Solution {
    public int solution(int n) {
        
        int nCount = Integer.bitCount(n);//2진수의 1의 갯수를 반환하는 메소드
        //Integer.toBinaryString(n) 2진수로 반환
        int nextNum = n + 1;
        while(true){
            int nextNumCount = Integer.bitCount(nextNum);
            if(nextNumCount == nCount){
                return nextNum;
            }
            nextNum++;
        }
    }
    
}