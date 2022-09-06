class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        
        Arrays.sort(nums);
        int n = nums.length;
        
        
        int currElement = nums[0];
        
        for(int i = 0 ; i < n ;){
            int count = 0 ;
                       
            while(i< n && nums[i] == currElement ){
                count++;
                i++;
            }
            if(count > n/3 ){
                ans.add(nums[i-1]);
            }
            if(i < n ){
            currElement = nums[i];}
            
            
        }
        
        return ans;
    }
}