class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> save=new HashMap<Character,Integer>();
        int[] re=new int[s.length()];
        if(s.length()==1) return 0;
        for(int i=0;i<s.length();i++){
            if(save.containsKey(s.charAt(i))) {
                re[i]=1;
                int h=save.get(s.charAt(i));
                re[h]=1;
                save.put(s.charAt(i),i);  
                continue;
            }
            char p=s.charAt(i);
            save.put(p,i);            
            re[i]=0;
        }
        for(int j=0;j<s.length();j++){
            if(re[j]==0) return j;
        }
        return -1;
    }
}
