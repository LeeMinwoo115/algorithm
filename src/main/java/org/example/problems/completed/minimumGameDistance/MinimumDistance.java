package org.example.problems.completed.minimumGameDistance;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDistance {

	public int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;

		int[][] dist = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0, 0});
		visited[0][0] = true;
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			if (x == n-1 && y == m-1) {
				return dist[x][y];
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (maps[nx][ny] == 0 || visited[nx][ny]) {
					continue;
				}

				visited[nx][ny] = true;
				dist[nx][ny] = dist[x][y] + 1;
				queue.offer(new int[]{nx, ny});
			}
		}

		return -1;
	}
}
