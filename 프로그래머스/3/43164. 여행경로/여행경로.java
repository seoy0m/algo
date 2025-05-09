import java.util.*;

class Solution {
    
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] used;
    
    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
 

        dfs(0,"ICN","ICN",tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    static void dfs(int depth, String start, String path, String[][] tickets){
        if(depth==tickets.length){
            list.add(path);
            return;
        }
        
        for(int i =0; i< used.length; i++){
            
            if(!used[i] && start.equals(tickets[i][0])){
                used[i]=true;
                // System.out.println(path);
                dfs(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                
                used[i]=false;
            }
        }
    }
}