package org.example.problems.completed.minimumGameDistance;

import java.util.ArrayList;
import java.util.List;

import org.example.global.objects.Answer;

public class Main {
	public static void main(String[] args) {
		int[][] arr1 = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 1},
			{0, 0, 0, 0, 1}
		};
		int expected1 = 11;

		int[][] arr2 = {
			{1, 0, 1, 1, 1},
			{1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1},
			{1, 1, 1, 0, 0},
			{0, 0, 0, 0, 1}
		};
		int expected2 = -1;

		MinimumDistance problem1 = new MinimumDistance();
		MinimumDistance problem2 = new MinimumDistance();

		List<Answer> answers = new ArrayList<>();

		answers.add(new Answer(problem1.solution(arr1), expected1));
		answers.add(new Answer(problem2.solution(arr2), expected2));

		int count = 1;
		for (Answer answer: answers) {
			answer.printAndCompare(String.format("%s case:", count));
		}
	}
}
