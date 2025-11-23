package org.example.problems.completed.searchDungeon;

import java.util.ArrayList;
import java.util.List;

public class SearchDungeon {
	static int maximum = 0;

	public int solution(int k, int[][] dungeons) {
		boolean[] visited = new boolean[dungeons.length];

		for(int i =0; i<dungeons.length; i++) {
			int remain = k - dungeons[i][1];
			int required = dungeons[i][0];

			if (k >= required) {
				dfs(dungeons, visited, remain, i, 0);
			}
			visited[i] = false;
		}

		return maximum;
	}

	public static void dfs(int[][] dungeons, boolean[] visited, int remain, int current, int count) {
		visited[current] = true;
		count++;

		for(int i = 0; i<dungeons.length; i++) {
			int upcomingRemain = remain - dungeons[i][1];
			int required = dungeons[i][0];

			if (remain >= required && !visited[i]) {
				dfs(dungeons, visited, upcomingRemain, i, count);
				maximum = Math.max(maximum, count);
				visited[i] = false;
			}
		}

		maximum = Math.max(maximum, count);
	}
}
