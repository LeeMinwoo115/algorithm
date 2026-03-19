import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> timeToInt(a[0]) - timeToInt(b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<book_time.length; i++) {
            int start = timeToInt(book_time[i][0]);
            int end = timeToInt(book_time[i][1]) + 10;
            
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end);
        }
        
        return pq.size();
    }
    
    private int timeToInt(String time) {
        String[] unit = time.split(":");
        return Integer.parseInt(unit[0])*60 + Integer.parseInt(unit[1]);
    }
}