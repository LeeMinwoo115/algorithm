package org.example.problems.completed.targetNumber;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.targetNumber.dto.TargetNumberInput;

public class Main {
	public static void main(String[] args) {
		TargetNumber targetNumber = new TargetNumber();
		Solver<TargetNumberInput, Integer> solver =
			input -> targetNumber.solution(input.numbers(), input.target());

		List<TestCase<TargetNumberInput, Integer>> testCases = List.of(
			new TestCase<>(
				"{1, 1, 1, 1, 1}, target: 3, expected: 5",
				new TargetNumberInput(
					new int[]{1, 1, 1, 1, 1},
					3
				),
				5
			),
			new TestCase<>(
				"{4, 1, 2, 1}, target: 4, expected: 2",
				new TargetNumberInput(
					new int[]{4, 1, 2, 1},
					4
				),
				2
			)
		);

		AlgorithmTestRunner.runTests("TargetNumber", solver, testCases);
	}
}
