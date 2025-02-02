package Matrix;

public class ConnenctedComponents {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 1, 1}
        };
        System.out.println(findConnectedComponents(grid));
    }

    private static int findConnectedComponents(int[][] grid){
        if(grid == null || grid.length == 0){
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;

        // Check if the cell is out of bounds or already visited or not a 1
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        //Mark the cell as visited
        visited[row][col] = true;
        //directions array for up, down, right, left

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        //visit all 4 neighbors
        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dRow[i], col + dCol[i], visited);
        }

    }
}
