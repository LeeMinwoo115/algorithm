package org.example.problems.completed.network;

public class Network {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i=0; i<n; i++) {
			if (!visited[i]) {
				answer += dfs(computers, n, i, visited);
			}
		}

		return answer;
	}

	private int dfs(int[][] computers, int n, int i, boolean[] visited) {

		visited[i] = true;
		for (int j=0; j<computers[i].length; j++) {
			if(!visited[j] && i!=j && computers[i][j] == 1) {
				dfs(computers, n, j, visited);
			}
		}

		return 1;
	}
}
