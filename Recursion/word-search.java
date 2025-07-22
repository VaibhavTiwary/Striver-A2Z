// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Time Complexity: O(m * n * 4^L)
// Where:

// m = number of rows in the board

// n = number of columns in the board

// L = length of the word to search

// Breakdown:
// You try starting the word from every cell → O(m * n)

// From each starting cell, in worst case, each letter can go in 4 directions → O(4^L)

// You use a visited matrix to prevent revisiting in the same path, but the branching factor is still up to 4 per character.


class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[] di = {0,0,1,-1};
        int[] dj = {1,-1,0,0};

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(board[row][col] == word.charAt(0)){
                   boolean found =  backtrack(board, word, row, col, 0, m, n, di, dj);
                   if(found) return true;
                }
            }
        }
        return false;
        
    }

    boolean backtrack(char[][] board, String word, int row, int col, int index, int m, int n, int[] di,int[] dj){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= m || col >= n || board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; 

        String directions= "DLRU";
        
        for(int i = 0; i < 4; i++){
            int nexti = row + di[i];
            int nextj = col + dj[i];
        
            if(backtrack(board, word, nexti, nextj, index+1, m, n, di, dj)){
                return true;
            }
            
        }
        board[row][col] = temp;
        return false;
    }
}



class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (backtrack(board, word, row, col, 0, visited, di, dj)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, int row, int col, int index,
                      boolean[][] visited, int[] di, int[] dj) {
        if (index == word.length()) return true;

        int m = board.length;
        int n = board[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nexti = row + di[i];
            int nextj = col + dj[i];
            if (backtrack(board, word, nexti, nextj, index + 1, visited, di, dj)) {
                return true;
            }
        }

        visited[row][col] = false; // backtrack
        return false;
    }
}
