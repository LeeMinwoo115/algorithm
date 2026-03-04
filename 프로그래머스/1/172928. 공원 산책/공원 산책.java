class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int n = park.length;
        int m = park[0].length();
        
        char[][] map = new char[n][m];
        
        int curX = 0;
        int curY = 0;
        
        for(int i=0; i<n; i++) {
            map[i] = park[i].toCharArray();
            
            for(int j=0; j<m; j++) {
                if (map[i][j] == 'S') {
                    curX = i;
                    curY = j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] elems = routes[i].split(" ");
            int distance = Integer.valueOf(elems[1]);
            
            int nx = curX;
            int ny = curY;
            
            for(int j=0; j<distance; j++) {
                if (elems[0].equals("E")) {
                    ny++;
                } else if(elems[0].equals("S")) {
                    nx++;
                } else if(elems[0].equals("N")) {
                    nx--;
                } else if(elems[0].equals("W")) {
                    ny--;
                }   
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 'X') {
                        break;
                    }
                    
                    if (j == distance - 1) {
                        curX = nx;
                        curY = ny;
                    }
                }
            }
        }
        
        return new int[]{curX, curY};
    }
}