class Solution {
    //1.构建int[] nums[nums.length-2]储存所有（和-target）最后return num[0]+target
    //time complex太高了，time out
    //2.我抄答案了
    //先排序再第二个加最后一个，依此类推
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
    int closest=nums[0]+nums[1]+nums[2];
    int low,high;
    for(int i=0;i<nums.length-1;i++){
        low=i+1;
        high=nums.length-1;
        while(low<high){
            if(nums[low]+nums[high]==target-nums[i]) return target;
            else if(nums[low]+nums[high]>target-nums[i]){
                while(low<high&&nums[low]+nums[high]>target-nums[i]) high--;
                if(Math.abs(nums[i]+nums[low]+nums[high+1]-target)<Math.abs(closest-target))
                    closest=nums[i]+nums[low]+nums[high+1];
            }
            else{
                while(low<high&&nums[low]+nums[high]<target-nums[i]) low++;
                if(Math.abs(nums[i]+nums[low-1]+nums[high]-target)<Math.abs(closest-target))
                    closest=nums[i]+nums[low-1]+nums[high];
            }
        }
    }
    return closest;
}
        
}
    
    
    
//     List<Integer> num=new ArrayList<Integer>();
//         List<Integer> num2=new ArrayList<Integer>();
//         //Arrays.sort(nums);
//         for(int i=0;i<nums.length-2;i++){
//             for(int j=i+1;j<nums.length-1;j++){
//                 for(int z=j+1;z<nums.length;z++){
//                     int p=nums[i]+nums[j]+nums[z];
//                     int result=p-target;
//                     if(result>=0) num.add(result);
//                     if(result<0) num2.add(result);
//                 }
//             }
            
//         }
//         Collections.sort(num);
//         Collections.sort(num2);
//         Collections.reverse(num2);
//         System.out.println("num="+num);
//         System.out.println("num2="+num2);
//         if(num.isEmpty())return (num2.get(0)+target);
//         if(num2.isEmpty())return (num.get(0)+target);
//         if(num.get(0)+num2.get(0)>0) return (num2.get(0)+target);
//         System.out.println("num-0="+(num.get(0)+target));
//         return (num.get(0)+target);
