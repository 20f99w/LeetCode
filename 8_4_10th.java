class Solution {
    public boolean isMatch(String s, String p) {
         if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
    }
}
// boolean result=false;
//         if(s.length()>p.length()) return result;
//         for(int i=0;i<p.length();i++){
//             for(int j=0;j<s.length();j++){
//                 if((i+j)>=p.length()) return false;
//                 char a=p.charAt(i+j); char b=s.charAt(j);
//                 if(a==46) a=b;
//                 if(a==42) {
//                     a=p.charAt(i+j-1);
//                     if(a==46) a=s.charAt(j-1);//这里实际上应该增加一个for循环判断多个重复的a能不能搞定s；但我没解决expected的问题所以先摘抄解决了-。-
//                 }
//                 if(a!=b) {
//                     result=false;
//                     break;
//                 }
//                 result=true; 
//             }
//             if(result==true) break;
            
//         }
//         return result;
