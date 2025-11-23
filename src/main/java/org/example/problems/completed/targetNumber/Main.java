package org.example.problems.completed.targetNumber;

import java.util.ArrayList;
import java.util.List;

import org.example.global.objects.Answer;

public class Main {
	public static void main(String[] args) {
		int[] arr1 = {1, 1, 1, 1, 1};
		int target1 = 3;
		int expected1 = 5;

		int[] arr2 = {4, 1, 2, 1};
		int target2 = 4;
		int expected2 = 2;

		TargetNumber answer1 = new TargetNumber();
		TargetNumber answer2 = new TargetNumber();

		List<Answer> answers = new ArrayList<>();

		answers.add(new Answer(answer1.solution(arr1, target1), expected1));
		answers.add(new Answer(answer2.solution(arr2, target2), expected2));

		int count = 1;
		for (Answer answer: answers) {
			answer.printAndCompare(String.format("%s case:", count));
		}
	}
}
