import java.util.*;

class Solution {
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        int[] results = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (land[x][y] == 1 && !visited[x][y]) {
                    bfs(land, visited, x, y, results);
                }
            }
        }
        
        for(int y=0; y<m; y++) {
            answer = Math.max(answer, results[y]);
        }
        
        return answer;
    }
    
    private void bfs(int[][] land, boolean[][] visited, int x, int y, int[] results) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> cols = new HashSet<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int size = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            size++;
            cols.add(curY);
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (land[nx][ny] == 0) {
                    continue;
                }
                
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        
        for (int col: cols) {
            results[col] += size;
        }
    }
}