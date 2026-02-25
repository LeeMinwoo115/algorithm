import java.util.*;

class Solution {
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        char[][] grid = new char[n][m];
        int sx = -1;
        int sy = -1;
        int lx = -1;
        int ly = -1;
        int ex = -1;
        int ey = -1;

        for (int i = 0; i < n; i++) {
            grid[i] = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'S') { sx = i; sy = j; }
                else if (grid[i][j] == 'L') { lx = i; ly = j; }
                else if (grid[i][j] == 'E') { ex = i; ey = j; }
            }
        }

        int distSL = bfs(grid, sx, sy, lx, ly);
        if (distSL == -1) return -1;

        int distLE = bfs(grid, lx, ly, ex, ey);
        if (distLE == -1) return -1;

        return distSL + distLE;
    }

    private int bfs(char[][] grid, int startX, int startY, int targetX, int targetY) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == targetX && y == targetY) {
                return dist[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || grid[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}