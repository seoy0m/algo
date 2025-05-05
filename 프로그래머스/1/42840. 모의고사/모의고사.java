import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int n = answers.length;
        
        int[] a = new int[n];     int[] b = new int[n];     int[] c = new int[n];
        int as =0;      int bs = 0;      int cs = 0;
        
        int[] bi= {1,3,4,5};        int[] ci= {3,1,2,4,5};
        int bj = 0;        int cj=0;
        
        for(int i=0; i< n; i++){
            a[i]= i%5+1; 
        }
        System.out.println(Arrays.toString(a));
        //2
        for(int i =0; i<n; i++){
            
            if(i%2==0){
                b[i]=2;

            } else{
                b[i]=bi[bj%4];
                bj++;
            }
            
        }
        System.out.println(Arrays.toString(b));
        
        for(int i=0; i<n; i++){
                                   
            if(i%2==0){  
                if(i+1<n){
            c[i]=ci[cj%5];
            c[i+1]=ci[cj%5];}
                else{
                c[i]=ci[cj%5];
                }
            cj++;
            }
        }
        System.out.println(Arrays.toString(c));
        
        for(int i=0; i<n; i++){
            if(answers[i]==a[i]) as++;
            if(answers[i]==b[i]) bs++;
            if(answers[i]==c[i]) cs++;
        }
        
        int max= 0;
        
        max= Math.max(as,bs);
        max= Math.max(cs,max);
        
        
        List<Integer> list = new ArrayList<>();
        
            if(max==as) list.add(1);
            if(max==bs) list.add(2);
            if(max==cs) list.add(3);
        
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
    answer[i] = list.get(i); // 언박싱
}
            
        
        
        return answer;
    }
}