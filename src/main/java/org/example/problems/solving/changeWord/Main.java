package org.example.problems.solving.changeWord;

import java.util.ArrayList;
import java.util.List;

import org.example.global.objects.Answer;

public class Main {
	public static void main(String[] args) {
		String begin1 = "hit";
		String target1 = "cog";
		String[] arr1 = {"hot", "dot", "dog", "lot", "log", "cog"};
		int expected1 = 4;

		String begin2 = "hit";
		String target2 = "cog";
		String[] arr2 = {"hot", "dot", "dog", "lot", "log"};
		int expected2 = 0;

		ChangeWord changeWord1 = new ChangeWord();
		ChangeWord changeWord2 = new ChangeWord();

		int result1 = changeWord1.solution(begin1, target1, arr1);
		int result2 = changeWord2.solution(begin2, target2, arr2);

		List<Answer> answers = new ArrayList<>();

		answers.add(new Answer(result1, expected1));
		answers.add(new Answer(result2, expected2));

		int count = 1;
		for (Answer answer: answers) {
			answer.printAndCompare(String.format("%s case:", count));
		}
	}
}
