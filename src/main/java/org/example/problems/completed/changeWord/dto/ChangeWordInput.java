package org.example.problems.completed.changeWord.dto;

public record ChangeWordInput (
	String begin,
	String target,
	String[] words
) {}
