class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0 , j = tokens.length-1 , score = 0 ;
        
        
        while(i <= j ){
            if(tokens[i] <= power) {
                power -= tokens[i];
                i++; 
                score++;
            }
            else {
                
                if(score > 0 && i!=j){
                    power += tokens[j];
                    score -- ;
                }
                j--;
            }
            
            
        }
        return score > 0 ? score :0 ;
        
    }
}