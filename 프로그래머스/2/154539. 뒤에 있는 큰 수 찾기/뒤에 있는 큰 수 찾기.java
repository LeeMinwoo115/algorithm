import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            while(!queue.isEmpty() && numbers[queue.peekLast()] < numbers[i]) {
                int idx = queue.pollLast();
                answer[idx] = numbers[i];
            }
            
            queue.addLast(i);
        }
        
        return answer;
    }
}