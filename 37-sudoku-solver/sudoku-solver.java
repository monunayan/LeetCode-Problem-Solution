class Solution {

    public void solveSudoku(char[][] board) {

        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        // Existing numbers mark karo
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {

                    int num = board[i][j] - '0';
                    int b = (i / 3) * 3 + (j / 3);

                    row[i][num] = true;
                    col[j][num] = true;
                    box[b][num] = true;
                }
            }
        }

        solve(board, row, col, box);
    }

    private boolean solve(char[][] board,
                          boolean[][] row,
                          boolean[][] col,
                          boolean[][] box) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.')
                    continue;

                int b = (i / 3) * 3 + (j / 3);

                for (int num = 1; num <= 9; num++) {

                    if (row[i][num] || col[j][num] || box[b][num])
                        continue;

                    // Number place karo
                    board[i][j] = (char) (num + '0');

                    row[i][num] = true;
                    col[j][num] = true;
                    box[b][num] = true;

                    // Aage solve karo
                    if (solve(board, row, col, box))
                        return true;

                    // Wrong choice → Backtrack
                    board[i][j] = '.';

                    row[i][num] = false;
                    col[j][num] = false;
                    box[b][num] = false;
                }

                return false;
            }
        }

        return true;
    }
}