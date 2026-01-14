import java.util.*;

class Solution {
    private String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        boolean[] visited = new boolean[tickets.length];
        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs(tickets, visited, "ICN", route);

        return answer;
    }

    private boolean dfs(String[][] tickets, boolean[] visited, String departure, List<String> route) {
        if (route.size() == tickets.length + 1) {
            answer = route.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && departure.equals(tickets[i][0])) {
                visited[i] = true;
                route.add(tickets[i][1]);

                if (dfs(tickets, visited, tickets[i][1], route)) return true;

                route.remove(route.size() - 1);
                visited[i] = false;
            }
        }
        return false;
    }
}