import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x==y) {
            return 0;
        }
        
        int[] dist = new int[y + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        dist[x] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int nextDist = dist[cur] + 1;
            
            int a = cur + n;
            int b = cur * 2;
            int c = cur * 3;
            
            if (a <= y && dist[a] == -1) {
                dist[a] = nextDist;
                if (a == y) {
                    return nextDist;
                }
                q.add(a);
            }
            
            if (b <= y && dist[b] == -1) {
                dist[b] = nextDist;
                if (b==y) {
                    return nextDist;
                }
                q.add(b);
            }
            
            if (c <= y && dist[c] == -1) {
                dist[c] = nextDist;
                if (c==y) {
                    return nextDist;
                }
                q.add(c);
            }
        }
        
        return -1;
    }
}