class Solution {
    public int majorityElement(int[] nums) {
        int count = 0 ; 
        int maxElement = 0;
        
        for(int num : nums ){
            if (count == 0 ){
                maxElement = num;
                count++;
            }else{
                if(num == maxElement){
                    count++;
                }
                else{
                    count--;
                }
            }
        }
        return maxElement;
        
    }
}