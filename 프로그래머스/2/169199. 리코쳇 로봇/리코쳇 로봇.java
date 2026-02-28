import java.util.*;

class Solution {
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        
        char[][] boardMap = new char[n][m];
        
        for (int i=0; i<n; i++) {
            boardMap[i] = board[i].toCharArray();
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        int startX = 0;
        int startY = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (boardMap[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if (boardMap[x][y] == 'G') {
                return dist[x][y];
            }
            
            for (int i=0; i<4; i++) {
                int nx = x;
                int ny = y;
                
                while (true) {
                    int tx = nx + dx[i];
                    int ty = ny + dy[i];
                    
                    if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                        break;
                    }

                    if (boardMap[tx][ty] == 'D') {
                        break;
                    }
                    
                    nx = tx;
                    ny = ty;
                }
                
                if (nx == x && ny == y) {
                    continue;
                }
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
}