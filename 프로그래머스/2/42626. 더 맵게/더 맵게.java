import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int answer = 0;
        
        for(int i=0;i<scoville.length;i++){
            queue.offer(scoville[i]);
        }
        
        int temp,sum=0;
        while(!queue.isEmpty()&&queue.peek()<K){
            temp = queue.poll();
            if(queue.isEmpty()&&temp<K){
                answer= -1;
                break;
            }
            sum = minScoville(temp,queue.poll());
            queue.offer(sum);
            answer++;
        }
        
        return answer;
    }
    
    private int minScoville(int first,int second){
        return first+(second*2);
    }
}