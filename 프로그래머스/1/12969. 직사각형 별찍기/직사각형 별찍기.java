import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        for(int i =0; i<m ; i++){
            String answer = "";
            for(int j =0; j<n ; j++){
                answer+= "*";
            }
            System.out.println(answer);
        }

        
    }
}