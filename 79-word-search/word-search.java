class Solution {

    int m, n;

    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word,
                int row, int col, int index) {

        // Word complete
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= m ||
            col < 0 || col >= n) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
                dfs(board, word, row - 1, col, index + 1) ||
                dfs(board, word, row + 1, col, index + 1) ||
                dfs(board, word, row, col - 1, index + 1) ||
                dfs(board, word, row, col + 1, index + 1);

        // Backtrack
        board[row][col] = temp;

        return found;
    }
}