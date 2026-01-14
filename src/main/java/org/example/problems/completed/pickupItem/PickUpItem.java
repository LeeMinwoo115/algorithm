package org.example.problems.completed.pickupItem;

import java.util.LinkedList;
import java.util.Queue;

public class PickUpItem {

	private static final int MAX = 110;
	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};

	public int solution(
		int[][] rectangle,
		int characterX,
		int characterY,
		int itemX,
		int itemY
	) {
		// 미로처럼 맵을 먼저 만들어보자
		int[][] map = createBorderMap(rectangle);

		// 맵 출력 확인용
		System.out.print("New Test Case");
		printMap(map, 22, 22);

		// 그리고 캐릭터가 길을 따라 아이템을 찾을 수 있는 최단 거리를 찾아보자
		boolean[][] visited = new boolean[MAX][MAX];
		int[][] dist = new int[MAX][MAX];

		int characterXDouble = characterX * 2;
		int characterYDouble = characterY * 2;
		int itemXDouble = itemX * 2;
		int itemYDouble = itemY * 2;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{characterXDouble, characterYDouble});
		dist[characterXDouble][characterYDouble] = 0;
		visited[characterXDouble][characterYDouble] = true;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];

			if (x == itemXDouble && y == itemYDouble) {
				return dist[x][y] / 2;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) {
					continue;
				}

				if (visited[nx][ny]) {
					continue;
				}

				if (map[nx][ny] == 0) {
					continue;
				}

				queue.offer(new int[]{nx, ny});
				dist[nx][ny] = dist[x][y] + 1;
				visited[nx][ny] = true;
			}
		}

		return 0;
	}

	private int[][] createBorderMap(int[][] rectangles) {
		int[][] map = new int[MAX][MAX];

		for (int[] r : rectangles) {
			int x1 = r[0] * 2;
			int y1 = r[1] * 2;
			int x2 = r[2] * 2;
			int y2 = r[3] * 2;

			for (int x = x1; x <= x2; x++) {
				for (int y = y1; y <= y2; y++) {

					// "내부" (테두리 제외)
					if (x1 < x && x < x2 && y1 < y && y < y2) {
						map[x][y] = 2;
					} else {
						// 테두리: 내부(2)가 아니면 1로
						if (map[x][y] != 2) {
							map[x][y] = 1;
						}
					}
				}
			}
		}

		// 내부(2)는 이동 불가로 0 처리, 테두리(1)만 남김
		for (int x = 0; x < MAX; x++) {
			for (int y = 0; y < MAX; y++) {
				if (map[x][y] == 2) {
					map[x][y] = 0;
				}
			}
		}

		return map;
	}

	public static void printMap(int[][] map, int maxX, int maxY) {
		for (int y = maxY; y >= 0; y--) {
			for (int x = 0; x <= maxX; x++) {
				System.out.print(map[x][y] == 1 ? "*" : " ");
			}
			System.out.println();
		}
	}
}
