class Solution {
//这个完全照搬了还没理解，明天继续
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int left, int right, int n){
        
        if(str.length() == n*2){
            list.add(str);
            return;
        }
        if(left < n)
            backtrack(list, str+"(", left+1, right, n);
        if(right < left)
            backtrack(list, str+")", left, right+1, n);
    }
}
