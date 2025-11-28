package org.example.global.test;

@FunctionalInterface
public interface Solver<I, O> {
	O solve(I input);
}
