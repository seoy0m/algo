class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int[] dh = {-1,1,0,0};
        int[] dw = {0,0,-1,1};
        
        String now = board[h][w];
        int answer = 0;
        
        int n = board.length;
        
        for(int i =0; i<4 ; i++){
            int newh= h+dh[i];
            int neww= w+dw[i];
            
            if(newh <0 || newh >= n
               || neww <0 || neww >= n) continue;
            
            if(now.equals(board[newh][neww])) answer++;
        }
        
        
        return answer;
    }
}