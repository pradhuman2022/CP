public class Solution {
    public int solve(String A, String B) {
    int dp[][] = new int[A.length() + 1][B.length() + 1] ; 
   /* for(int i = 0; i < A.length(); i++)
     {
          for(int j = 0 ; j < B.length(); j++)
          {
              dp[i][j] = -1 ;
          }
     }
    return lcs(0, 0, A, B, dp) ;*/
    
    for(int i = 1 ; i <= A.length() ; i++)
    {
           for(int j = 1 ; j <= B.length() ; j++)
           {
                if(A.charAt(i - 1) == B.charAt(j - 1))
                 {
                     dp[i][j] = 1 + dp[i - 1][j - 1] ;
                 }
                 else
                 {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) ;
                 }
           }
    }
     return dp[A.length()][B.length()] ;
    
    }
    
    public int lcs(int n, int m , String A, String B, int dp[][])
    {
         if(n == A.length() || m == B.length())
            return 0 ;
         if(dp[n][m] != -1)
           return dp[n][m] ;
         int ans ;
         if(A.charAt(n) == B.charAt(m))
         {
             ans = 1 + lcs(n + 1, m + 1, A, B, dp) ;
         }
         else
         {
          ans = Math.max(lcs(n + 1, m , A, B, dp), lcs(n, m + 1, A, B, dp)) ; 
         }
         return dp[n][m] = ans ;
    }
}
