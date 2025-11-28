package org.example.problems.solving.changeWord.dto;

public record ChangeWordInput (
	String begin,
	String target,
	String[] words
) {}
