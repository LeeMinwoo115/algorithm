import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean ck;
        String[] skills = skill.split("");
        
        Queue<String> queue = new LinkedList<String>();
        Queue<String> compQ = new LinkedList<String>();
        
        for(int i=0;i<skill_trees.length;i++){
            ck = true;
            
            for(int j=0;j<skills.length;j++){
                queue.add(skills[j]);
            }
            
            for(int j=0;j<skill_trees[i].length();j++){
                compQ.add(Character.toString(skill_trees[i].charAt(j)));
            }
            
            while(!compQ.isEmpty()){
                if(queue.isEmpty()) break;
                if(queue.contains(compQ.peek())){
                    if(queue.peek().equals(compQ.peek())){
                        ck=true;
                        queue.poll();
                    }else{
                        ck=false;
                        break;
                    }
                }
                
                compQ.poll();
            }
            
            if(ck)  answer++;
            
            compQ.clear();
            queue.clear();
        }
        return answer;
    }
}