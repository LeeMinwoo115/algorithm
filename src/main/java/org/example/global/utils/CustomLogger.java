package org.example.global.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {
	private final Logger logger;
	private static final CustomLogger instance = new CustomLogger();

	private CustomLogger() {
		logger = Logger.getLogger("CustomerLogger");
		logger.setUseParentHandlers(false);

		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new ColorLogFormatter());
		consoleHandler.setLevel(Level.ALL);

		logger.addHandler(consoleHandler);
		logger.setLevel(Level.ALL);
	}

	public static CustomLogger getInstance() {
		return instance;
	}

	public void info(String message) {
		logger.log(Level.INFO, message);
	}

	public void warn(String message) {
		logger.log(Level.WARNING, message);
	}

	public void error(String message) {
		logger.log(Level.SEVERE, message);
	}
}
