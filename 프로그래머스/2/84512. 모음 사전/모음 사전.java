import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        
        for(int i=0; i<list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i;
            }
        }
        
        return answer;
    }
    
    private void dfs(String str, int length) {
        list.add(str);
        
        if(length == 5) {
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            dfs(str + words[i], length + 1);
        }
    }
}