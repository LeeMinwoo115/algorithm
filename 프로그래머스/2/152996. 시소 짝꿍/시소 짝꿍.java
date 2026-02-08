import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        
        for (int weight: weights) {
            double w = (double)weight;
            double x = w*2.0/3.0;
            double y = w/2.0;
            double z = w*3.0/4.0;
            
            if(map.containsKey(w)) {
                answer += map.get(w);
            }
            
            if(map.containsKey(x)) {
                answer += map.get(x);
            }
            
            if(map.containsKey(y)) {
                answer += map.get(y);
            }
            
            if(map.containsKey(z)) {
                answer += map.get(z);
            }
            
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        return answer;
    }
}