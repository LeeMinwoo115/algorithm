import java.util.*;

class Solution {
    class Missile {
        int start;
        int end;
        boolean isAlive = true;
        
        Missile(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        void updateIsAlive() {
            this.isAlive = !this.isAlive;
        }
    }
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        List<Missile> missiles = new ArrayList<>();
        
        for (int[] target: targets) {
            missiles.add(new Missile(target[0], target[1]));
        }
        
        missiles.sort((obj1, obj2) -> {
            if (obj1.end == obj2.end) {
                return obj1.start - obj2.start;
            }
            
            return obj1.end - obj2.end;
        });
        
        int endPoint = 0;
        
        for (int i = 0; i < missiles.size(); i++) {
            if (missiles.get(i).start >= endPoint) {
                answer++;
                endPoint = missiles.get(i).end;
            }
        } 
        
        return answer;
    }
}