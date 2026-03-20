import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        boolean flag = false;
        Integer[] nums = new Integer[citations.length];
        for(int i=0;i<citations.length;i++){
            nums[i]=citations[i];
        }
        Arrays.sort(nums,Collections.reverseOrder());
        
        int h_index=nums.length;
        while(true){
            int cnt=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]>=h_index){
                    cnt++;
                }
            }
            if(cnt>=h_index){
                break;
            }
            h_index--;
        }
        
        answer = h_index;
        return answer;
    }
}