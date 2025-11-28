package org.example.global.test;

import java.util.List;

import org.example.global.utils.StandardUtils;

public class AlgorithmTestRunner {

	public static <I, O> void runTests(
		String problemName,
		Solver<I, O> solver,
		List<TestCase<I, O>> testCases
	) {
		System.out.println("===" + problemName + "===");

		for (int i = 0; i < testCases.size(); i++) {
			TestCase<I, O> testCase = testCases.get(i);
			String caseName = String.format("Case %d - %s", i + 1, testCase.getName());

			O result = solver.solve(testCase.getInput());

			StandardUtils.printAndCompare(caseName, result, testCase.getExpected());
		}
	}
}
