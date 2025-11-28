package org.example.problems.completed.searchDungeon;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.searchDungeon.dto.SearchDungeonInput;

public class Main {
    public static void main(String[] args) {
        SearchDungeon searchDungeon = new SearchDungeon();
        Solver<SearchDungeonInput, Integer> solver =
            input -> searchDungeon.solution(input.capacity(), input.dungeons());

        List<TestCase<SearchDungeonInput, Integer>> testCases = List.of(
            new TestCase<>(
                "k: 80, dungeons: {{80, 20}, {50, 40}, {30, 10}}, expected: 3",
                new SearchDungeonInput(
                    80,
                    new int[][]{{80, 20}, {50, 40}, {30, 10}}
                ),
                3
            )
        );

        AlgorithmTestRunner.runTests("SearchDungeon", solver, testCases);
    }
}
