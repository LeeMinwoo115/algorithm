package org.example.problems.completed.network;

import java.util.ArrayList;
import java.util.List;

import org.example.global.objects.Answer;

public class Main {
	public static void main(String[] args) {
		int n1 = 3;
		int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; // return 2
		int expected1 = 2;

		int n2 = 3;
		int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}; // return 1
		int expected2 = 1;

		Network network1 = new Network();
		Network network2 = new Network();

		int result1 = network1.solution(n1, computers1);
		int result2 = network2.solution(n2, computers2);

		List<Answer> answers = new ArrayList<>();

		answers.add(new Answer(result1, expected1));
		answers.add(new Answer(result2, expected2));

		int count = 1;
		for (Answer answer: answers) {
			answer.printAndCompare(String.format("%s case:", count));
		}
	}
}
