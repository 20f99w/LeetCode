class Solution {
    //是否能整除3，能的话再判断整除的数是否能整除3直到==3
    public boolean isPowerOfThree(int n) {
        boolean kaiguan=false;
        boolean result=false;
        if(n<=0)return kaiguan;
        if(n==1)kaiguan=true;
        //System.out.println("n%3="+n%3);
        if(n%3==0){
            if((n/3)!=3){
                //System.out.println("n="+n);
                //System.out.println("result1="+kaiguan);
                result=isPowerOfThree(n/3);
                //System.out.println("result2="+result);
                return result;
                
                
            }
            kaiguan=true;   
        }
        //System.out.println("result3="+kaiguan);
        return kaiguan;
    }
}
