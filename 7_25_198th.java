class Solution {
    //firstly,we want to use the greedy algorithm，then we find it will ignore some cases.
    //so we study the answer.
    public int rob(int[] nums) {
        int onepart=0;
        int otherpart=0;
        
        for(int num:nums){
            int temp=onepart;
            onepart=Math.max(onepart,otherpart);
            otherpart=num+temp;
        }
        return Math.max(onepart,otherpart);  
    }
}
