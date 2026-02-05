import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        List<Integer> results = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        char[][] chMaps = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            chMaps[i] = maps[i].toCharArray();
        }
        
        for (int i=0; i<chMaps.length; i++) {
            for (int j=0; j<chMaps[i].length; j++) {
                if(!visited[i][j] && chMaps[i][j] != 'X') {
                    results.add(dfs(chMaps, visited, i, j));
                }
            }
        }
        
        if (results.isEmpty()) {
            return new int[]{-1};
        }
        
        return results.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private int dfs(char[][] maps, boolean[][] visited, int x, int y) {
        
        if (x<0 || x>=maps.length || y < 0 || y >= maps[x].length ||
           visited[x][y] || maps[x][y] == 'X') {
            return 0;
        }
        
        visited[x][y] = true;
        int sum = maps[x][y] - '0';
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            sum += dfs(maps, visited, nx, ny);
        }
        
        return sum;
    }
}