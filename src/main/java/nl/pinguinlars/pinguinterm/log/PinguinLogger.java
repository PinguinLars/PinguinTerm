package nl.pinguinlars.pinguinterm.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class PinguinLogger {
    public static final Logger log = Logger.getLogger(PinguinLogger.class.getName());
    private static Handler fileHandler;
    private final String logFileName, logFileExtension, logFileFullName;

    public PinguinLogger() {
        logFileExtension = ".log";
        logFileName = "PinguinTerm";
        logFileFullName = logFileName + logFileExtension;
        try {
            fileHandler = new FileHandler(logFileFullName, true);
            log.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
            log.info("Log file created");
        } catch (IOException e) {
            log.log(SEVERE, String.format("Couldn't create %s file", logFileFullName), e);
        } catch (Exception e) {
            log.log(SEVERE, "Unknown exception occurred", e);
        }
    }

    @SuppressWarnings("unused") //I don't know, I may use this later //PinguinLars
    public PinguinLogger(String logFileName, String logFileExtension) {
        this.logFileName = logFileName;
        this.logFileExtension = logFileExtension;
        this.logFileFullName = this.logFileName + this.logFileExtension;
        try {
            fileHandler = new FileHandler(logFileFullName, true);
            log.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
            log.log(INFO, "Log file created");
        } catch (IOException e) {
            log.log(SEVERE, String.format("Couldn't create %s file", logFileFullName), e);
        } catch (Exception e) {
            log.log(SEVERE, "Unknown exception occurred", e);
        }
    }
}