package org.example.problems.completed.targetNumber;

public class TargetNumber {
	int count = 0;
	String[] types = { "+", "-" };

	public int solution(int[] numbers, int target) {
		int depth = 1;
		int result = 0;
		count = 0;

		for (String type: types) {
			dfs(numbers, target, type, depth, result);
		}

		return count;
	}

	private void dfs(int[] numbers, int target, String type, int depth, int result) {
		int length = numbers.length;

		if (type.equals("+")) {
			result += numbers[depth - 1];
		} else {
			result -= numbers[depth - 1];
		}

		if (depth == length) {
			if (result == target) {
				count++;
			}
			return;
		}

		for (String operator: types) {
			dfs(numbers, target, operator, depth + 1, result);
		}
	}
}
