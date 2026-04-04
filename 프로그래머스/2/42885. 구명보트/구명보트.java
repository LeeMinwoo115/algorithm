import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int i=0,j;
        for(j=people.length-1;j>i;j--){
            if(people[j]+people[i]>limit)   answer++;
            else{
                i++;
                answer++;
            }
        }
        if(i==j)    answer++;
        return answer;
    }
    
}