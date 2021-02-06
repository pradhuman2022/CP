public class Solution {
    static int grid[][];
    public int[][] solve(int[][] A) {
        grid = A;
        
        int steps[][] = {{-1, 0},{0, -1}, {1, 0}, {0, 1}};
        int distance[][] = new int[A.length][A[0].length];
        for(int a[]: distance) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }
        
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1){
                    distance[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Pair currentCell = q.poll();
            for(int i = 0; i < 4; i++) {
                int newX = currentCell.x + steps[i][0];
                int newY = currentCell.y + steps[i][1];
                
                if(isValid(newX, newY)){
                    if(distance[newX][newY] > distance[currentCell.x][currentCell.y] + 1) {
                        distance[newX][newY] = distance[currentCell.x][currentCell.y] + 1;
                        q.add(new Pair(newX, newY));
                    }
                }
            }
        }
        
        return distance;
    }
    
    public boolean isValid(int row, int col) {
        if(row < 0 || col < 0 || grid.length <= row || grid[0].length <= col)
            return false;
            
        return true;
    }
    
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/**
Distance of nearest cell

Problem Description

Given a matrix of integers A of size N x M consisting of 0 or 1.

For each cell of the matrix find the distance of nearest 1 in the matrix.

Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.

Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.

NOTE: There is atleast one 1 is present in the matrix.



Problem Constraints

1 <= N, M <= 1000

0 <= A[i][j] <= 1



Input Format

The first argument given is the integer matrix A.


Output Format

Return the matrix B.


Example Input

Input 1:

 A = [
       [0, 0, 0, 1]
       [0, 0, 1, 1] 
       [0, 1, 1, 0]
     ]

Input 2:

 A = [
       [1, 0, 0]
       [0, 0, 0]
       [0, 0, 0]  
     ]



Example Output

Output 1:

 [ 
   [3, 2, 1, 0]
   [2, 1, 0, 0]
   [1, 0, 0, 1]   
 ]

Output 2:

 [
   [0, 1, 2]
   [1, 2, 3]
   [2, 3, 4] 
 ]



Example Explanation

Explanation 1:

 A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 A[1][0], A[1][1] will be nearest to A[1][2].
 A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].

Explanation 2:

 There is only a single 1. Fill the distance from that 1.
 **/
