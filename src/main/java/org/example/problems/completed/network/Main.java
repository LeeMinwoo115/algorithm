package org.example.problems.completed.network;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.network.dto.NetworkInput;

public class Main {
	public static void main(String[] args) {
		Network network = new Network();
		Solver<NetworkInput, Integer> solver =
			input -> network.solution(input.totalComputers(), input.computers());

		List<TestCase<NetworkInput, Integer>> testCases = List.of(
			new TestCase<>(
				"total: 3, computers: {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, expected: 3",
				new NetworkInput(
					3,
					new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
				),
				2
			),
			new TestCase<>(
				"total: 3, computers: {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}, expected: 1",
				new NetworkInput(
					3,
					new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}
				),
				1
			)
		);

		AlgorithmTestRunner.runTests("Network", solver, testCases);
	}
}
