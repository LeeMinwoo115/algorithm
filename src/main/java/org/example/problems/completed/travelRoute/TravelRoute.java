package org.example.problems.completed.travelRoute;

import java.util.ArrayList;
import java.util.List;

public class TravelRoute {

	public String[] solution(String[][] tickets) {
		List<List<String>> routes = new ArrayList<>();
		List<String> route = new ArrayList<>();
		boolean[] visited = new boolean[tickets.length];

		route.add("ICN");

		dfs(tickets, visited, "ICN", route, routes);

		routes.sort((a, b) -> {
			int n = Math.min(a.size(), b.size());
			for (int i = 0; i < n; i++) {
				int cmp = a.get(i).compareTo(b.get(i));
				if (cmp != 0) {
					return cmp;
				}
			}
			return Integer.compare(a.size(), b.size());
		});

		return routes.getFirst().toArray(new String[0]);
	}

	private void dfs(
		String[][] tickets,
		boolean[] visited,
		String departure,
		List<String> route,
		List<List<String>> routes
	) {

		boolean allTrue = true;

		for (boolean visit: visited) {
			if (!visit) {
				allTrue = false;
				break;
			}
		}

		if (allTrue) {
			List<String> deepCopy = new ArrayList<>();
			for (String place: route) {
				deepCopy.add(place);
			}
			routes.add(deepCopy);
		}

		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String target = tickets[i][1];

			if (departure.equals(start) && !visited[i]) {
				visited[i] = true;
				route.add(target);
				dfs(tickets, visited, target, route, routes);
				route.removeLast();
				visited[i] = false;
			}
		}
	}
}
