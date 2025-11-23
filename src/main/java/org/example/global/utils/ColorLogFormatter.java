package org.example.global.utils;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ColorLogFormatter extends Formatter {

	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String RED = "\u001B[31m";

	@Override
	public String format(LogRecord record) {
		String color;

		if (record.getLevel() == Level.INFO) {
			color = GREEN;
		} else if (record.getLevel() == Level.WARNING) {
			color = YELLOW;
		} else if (record.getLevel() == Level.SEVERE) {
			color = RED;
		} else {
			color = RESET;
		}

		String levelName = switch (record.getLevel().getName()) {
			case "INFO" -> "통과";
			case "SEVERE" -> "실패";
			default -> record.getLevel().getName();
		};

		return String.format(
			"%s[%s] %s%s%n%n",
			color,
			levelName,
			record.getMessage(),
			RESET
		);
	}
}
