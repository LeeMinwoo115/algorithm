package org.example.problems.completed.travelRoute;

import java.util.List;

import org.example.global.test.AlgorithmTestRunner;
import org.example.global.test.Solver;
import org.example.global.test.TestCase;
import org.example.problems.completed.travelRoute.dto.TravelRouteInput;

public class Main {
	public static void main(String[] args) {
		TravelRoute travelRoute = new TravelRoute();
		Solver<TravelRouteInput, String[]> solver =
			input -> travelRoute.solution(input.tickets());

		List<TestCase<TravelRouteInput, String[]>> testCases = List.of(
			new TestCase<>(
				"[[\"ICN\", \"JFK\"], [\"HND\", \"IAD\"], [\"JFK\", \"HND\"]], expected: [\"ICN\", \"JFK\", \"HND\", \"IAD\"]",
				new TravelRouteInput(
					new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}
				),
				new String[]{"ICN", "JFK", "HND", "IAD"}
			),
			new TestCase<>(
				"[[\"ICN\", \"SFO\"], [\"ICN\", \"ATL\"], [\"SFO\", \"ATL\"], [\"ATL\", \"ICN\"], [\"ATL\",\"SFO\"]],\n"
				+ "expected: [\"ICN\", \"ATL\", \"ICN\", \"SFO\", \"ATL\", \"SFO\"]",
				new TravelRouteInput(
					new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}
				),
				new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
			)
		);

		AlgorithmTestRunner.runTests("TravelRoute", solver, testCases);
	}
}
