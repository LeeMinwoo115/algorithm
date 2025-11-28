package org.example.global.test;

public class TestCase<I, O> {
	private final String name;
	private final I input;
	private final O expected;

	public TestCase(String name, I input, O expected) {
		this.name = name;
		this.input = input;
		this.expected = expected;
	}

	public String getName() {
		return this.name;
	}

	public I getInput() {
		return this.input;
	}

	public O getExpected() {
		return this.expected;
	}
}
