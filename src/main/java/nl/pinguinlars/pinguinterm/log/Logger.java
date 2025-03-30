package nl.pinguinlars.pinguinterm.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Level.SEVERE;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class Logger {
    private final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());
    @SuppressWarnings("FieldCanBeLocal")
    private final String logFileName, logFileExtension, logFileFullName;
    @SuppressWarnings("FieldCanBeLocal")
    private Handler fileHandler;
    private static Logger instance;

    private Logger() {
        logFileExtension = ".log";
        logFileName = "PinguinTerm";
        logFileFullName = logFileName + logFileExtension;
        try {
            fileHandler = new FileHandler(logFileFullName, true);
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.info("Log file created");
        } catch (IOException e) {
            logger.log(SEVERE, String.format("Couldn't create %s file", logFileFullName), e);
        } catch (Exception e) {
            logger.log(SEVERE, "Unknown exception occurred", e);
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(Level level, String msg) {
        logger.log(level, msg);
    }

    public void log(Level level, String msg, Throwable thrown) {
        logger.log(level, msg, thrown);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
        logger.logp(level, sourceClass, sourceMethod, msg);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object param1) {
        logger.logp(level, sourceClass, sourceMethod, msg, param1);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] params) {
        logger.logp(level, sourceClass, sourceMethod, msg, params);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Throwable thrown) {
        logger.logp(level, sourceClass, sourceMethod, msg, thrown);
    }

    public void info(String msg) {
        logger.info(msg);
    }

    public void fine(String msg) {
        logger.fine(msg);
    }

    public void finer(String msg) {
        logger.finer(msg);
    }

    public void finest(String msg) {
        logger.finest(msg);
    }

    public void severe(String msg) {
        logger.severe(msg);
    }
}