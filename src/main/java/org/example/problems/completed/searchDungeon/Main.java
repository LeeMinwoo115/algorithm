package org.example.problems.completed.searchDungeon;

import java.util.ArrayList;
import java.util.List;

import org.example.global.objects.Answer;

public class Main {
    public static void main(String[] args) {
        SearchDungeon sol = new SearchDungeon();

        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int expected = 3;

        int result = sol.solution(k, dungeons);

        List<Answer> answers = new ArrayList<>();

        answers.add(new Answer(result, expected));

        int count = 1;
        for (Answer answer: answers) {
            answer.printAndCompare(String.format("%s case:", count));
        }
    }
}
