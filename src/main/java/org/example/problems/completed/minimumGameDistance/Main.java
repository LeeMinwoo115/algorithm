package org.example.problems.completed.minimumGameDistance;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.minimumGameDistance.dto.MinGameDistanceInput;

public class Main {
	public static void main(String[] args) {
		int[][] map1 = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}
		};

		int[][] map2 = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1}
		};

		MinimumDistance minimumDistance = new MinimumDistance();
		Solver<MinGameDistanceInput, Integer> solver =
			input -> minimumDistance.solution(input.map());

		List<TestCase<MinGameDistanceInput, Integer>> testCases = List.of(
			new TestCase<>(
				"Map 1, expected: 11",
				new MinGameDistanceInput(
					map1
				),
				11
			),
			new TestCase<>(
				"Map 2, expected: -1",
				new MinGameDistanceInput(
					map2
				),
				-1
			)
		);

		AlgorithmTestRunner.runTests("MinimumDistance", solver, testCases);
	}
}
