package org.example.problems.completed.pickupItem;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.pickupItem.dto.PickUpItemInput;

public class Main {
	public static void main(String[] args) {
		PickUpItem pickUpItem = new PickUpItem();
		Solver<PickUpItemInput, Integer> solver =
			input -> pickUpItem.solution(
				input.rectangle(),
				input.characterX(),
				input.characterY(),
				input.itemX(),
				input.itemY()
			);

		List<TestCase<PickUpItemInput, Integer>> testCases = List.of(
			new TestCase<>(
				"Rectangle: {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, expected: 17",
				new PickUpItemInput(
					new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
					1,
					3,
					7,
					8
				),
				17
			),
			new TestCase<>(
				"Rectangle: {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, expected: 11",
				new PickUpItemInput(
					new int[][]{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},
					9,
					7,
					6,
					1
				),
				11
			),
			new TestCase<>(
				"Rectangle: {{1,1,5,7}}, expected: 9",
				new PickUpItemInput(
					new int[][]{{1,1,5,7}},
					1,
					1,
					4,
					7
				),
				9
			),
			new TestCase<>(
				"Rectangle: {{2,1,7,5},{6,4,10,10}}, expected: 15",
				new PickUpItemInput(
					new int[][]{{2,1,7,5},{6,4,10,10}},
					3,
					1,
					7,
					10
				),
				15
			),
			new TestCase<>(
				"Rectangle: {{2,2,5,5},{1,3,6,4},{3,1,4,6}}, expected: 10",
				new PickUpItemInput(
					new int[][]{{2,2,5,5},{1,3,6,4},{3,1,4,6}},
					1,
					4,
					6,
					3
				),
				10
			)
		);

		AlgorithmTestRunner.runTests("PickUpItem", solver, testCases);
	}
}
