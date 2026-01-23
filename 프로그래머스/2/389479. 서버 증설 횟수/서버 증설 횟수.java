import java.util.*;

class Solution {
    class Server {
        int startIndex;
        int endIndex;
        int quantity;
        
        Server(int startIndex, int endIndex, int quantity) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.quantity = quantity;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        List<Server> list = new ArrayList<>();
        
        for (int i=0; i<players.length; i++) {
            int playerTotal = players[i];
            int totalServer = 0;
            for (Server s: list) {
                totalServer += s.quantity;
            }
            
            int needServer = playerTotal / m;
            
            if (needServer > totalServer) {
                int addServer = needServer - totalServer;
                answer+= addServer;
                
                list.add(new Server(i, i + k - 1, addServer));
            }
            
            Iterator<Server> iterator = list.iterator();

            while (iterator.hasNext()) {
                Server server = iterator.next();
                if (server.endIndex == i) {
                    iterator.remove();
                }
            }
        }
        
        return answer;
    }
}