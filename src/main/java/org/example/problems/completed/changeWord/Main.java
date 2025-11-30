package org.example.problems.completed.changeWord;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.changeWord.dto.ChangeWordInput;

public class Main {
	public static void main(String[] args) {
		ChangeWordDFS changeWord = new ChangeWordDFS();
		Solver<ChangeWordInput, Integer> solver =
			input -> changeWord.solution(input.begin(), input.target(), input.words());

		List<TestCase<ChangeWordInput, Integer>> testCases = List.of(
			new TestCase<>(
				"기본 케이스 - cog 도달 가능",
				new ChangeWordInput(
					"hit",
					"cog",
					new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
				),
				4
			),
			new TestCase<>(
				"cog 미포함 - 도달 불가",
				new ChangeWordInput(
					"hit",
					"cog",
					new String[]{"hot", "dot", "dog", "lot", "log"}
				),
				0
			)
		);

		AlgorithmTestRunner.runTests("ChangeWord", solver, testCases);
	}
}
