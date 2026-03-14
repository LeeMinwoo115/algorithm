import java.util.*;

class Solution {
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    boolean[][] visited;
    List<int[]> removable;
    char[][] map;
    int n, m;
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        map = new char[n+2][m+2];
        
        for(int i=0; i<n + 2; i++) {
            Arrays.fill(map[i], '.');
        }
        
        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(String req: requests) {
            char target = req.charAt(0);
            
            if(req.length() == 2) {
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=m; j++) {
                        if(map[i][j] == target) {
                            map[i][j] = '.';
                        }
                    }
                }
            } else {
                visited = new boolean[n+2][m+2];
                removable = new ArrayList<>();
                
                dfs(0, 0, target);
                
                for (int[] pos : removable) {
                    map[pos[0]][pos[1]] = '.';
                }
            }
        }
        
        int answer = 0;
        for (int i=1; i<=n ;i++) {
            for (int j=1; j<=m; j++) {
                if (map[i][j] != '.') {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void dfs(int x, int y, char target) {
        visited[x][y] = true;
        
        for (int dir = 0; dir<4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= n+2 || ny < 0 || ny >= m+2) {
                continue;
            }
            
            if (visited[nx][ny]) {
                continue;
            }
            
            if (map[nx][ny] == '.') {
                dfs(nx, ny, target);
            } else if (map[nx][ny] == target) {
                visited[nx][ny] = true;
                removable.add(new int[]{nx, ny});
            }
        }
    }
}