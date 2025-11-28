package org.example.global.utils;

import java.util.Objects;

public class StandardUtils {

	private static final CustomLogger log = CustomLogger.getInstance();

	public static <T> void printAndCompare(String caseName, T result, T expected) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format(
			"%s\n결과값: %s (기대값: %s)\n",
			caseName,
			String.valueOf(result),
			String.valueOf(expected)
			)
		);

		if (result == null) {
			log.warn("결과값이 비었습니다.");
			return;
		}

		if (expected == null) {
			log.warn("정답(기대 결과값)이 비었습니다.");
			return;
		}

		if (Objects.equals(result, expected)) {
			sb.append("통과했습니다!");
			log.info(sb.toString());
		} else {
			sb.append(String.format(
				"결과값 '%s'이(가) 기대값 '%s'와(과) 다릅니다.",
				result,
				expected
			));
			log.error(sb.toString());
		}
	}
}
