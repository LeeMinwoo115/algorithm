package org.example.global.utils;

import java.util.Arrays;
import java.util.Objects;

public class StandardUtils {

	private static final CustomLogger log = CustomLogger.getInstance();

	public static <T> void printAndCompare(String caseName, T result, T expected) {
		StringBuilder sb = new StringBuilder();

		String resultStr = stringify(result);
		String expectedStr = stringify(expected);

		sb.append(String.format(
			"%s\n결과값: %s (기대값: %s)\n",
			caseName,
			resultStr,
			expectedStr
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

		boolean isEqual = equalsValue(result, expected);

		if (isEqual) {
			sb.append("통과했습니다!");
			log.info(sb.toString());
		} else {
			sb.append(String.format(
				"결과값 '%s'이(가) 기대값 '%s'와(과) 다릅니다.",
				resultStr,
				expectedStr
			));
			log.error(sb.toString());
		}
	}

	private static String stringify(Object object) {
		if (object == null) {
			return "null";
		}

		Class<?> cls = object.getClass();

		if (!cls.isArray()) {
			return String.valueOf(object);
		}

		if (object instanceof Object[]) {
			return Arrays.deepToString((Object[]) object);
		}

		if (object instanceof int[]) return Arrays.toString((int[]) object);
		if (object instanceof long[]) return Arrays.toString((long[]) object);
		if (object instanceof double[]) return Arrays.toString((double[]) object);
		if (object instanceof boolean[]) return Arrays.toString((boolean[]) object);
		if (object instanceof char[]) return Arrays.toString((char[]) object);
		if (object instanceof byte[]) return Arrays.toString((byte[]) object);
		if (object instanceof short[]) return Arrays.toString((short[]) object);
		if (object instanceof float[]) return Arrays.toString((float[]) object);

		return String.valueOf(object);
	}

	private static boolean equalsValue(Object a, Object b) {
		if (a == null || b == null) {
			return false;
		}

		Class<?> aClass = a.getClass();
		Class<?> bClass = b.getClass();

		if (aClass.isArray() && bClass.isArray()) {
			if (a instanceof Object[] && b instanceof Object[]) {
				return Arrays.deepEquals((Object[]) a, (Object[]) b);
			}

			if (a instanceof int[] && b instanceof int[])
				return Arrays.equals((int[]) a, (int[]) b);
			if (a instanceof long[] && b instanceof long[])
				return Arrays.equals((long[]) a, (long[]) b);
			if (a instanceof double[] && b instanceof double[])
				return Arrays.equals((double[]) a, (double[]) b);
			if (a instanceof boolean[] && b instanceof boolean[])
				return Arrays.equals((boolean[]) a, (boolean[]) b);
			if (a instanceof char[] && b instanceof char[])
				return Arrays.equals((char[]) a, (char[]) b);
			if (a instanceof byte[] && b instanceof byte[])
				return Arrays.equals((byte[]) a, (byte[]) b);
			if (a instanceof short[] && b instanceof short[])
				return Arrays.equals((short[]) a, (short[]) b);
			if (a instanceof float[] && b instanceof float[])
				return Arrays.equals((float[]) a, (float[]) b);
		}

		return Objects.equals(a, b);
	}
}
