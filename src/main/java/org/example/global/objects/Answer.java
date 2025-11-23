package org.example.global.objects;

import org.example.global.utils.StandardUtils;

public class Answer {

	private final Object result;
	private final Object expected;

	public Answer(Object result, Object expected) {
		this.result = result;
		this.expected = expected;
	}

	public void printAndCompare(String caseName) {
		StandardUtils.printAndCompare(caseName, this.result, this.expected);
	}
}
