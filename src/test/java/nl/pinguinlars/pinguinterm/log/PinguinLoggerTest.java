package nl.pinguinlars.pinguinterm.log;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class PinguinLoggerTest {

    private PinguinLogger pinguinLogger;
    private File logFile;

    @BeforeEach
    void setUp() {
        pinguinLogger = new PinguinLogger();
        logFile = new File("PinguinTerm.log");
    }

    @Test
    void testLoggerInitialization() {
        assertTrue(logFile.exists(), "Log file should be created");
    }

    @Test
    void testLogging() {
        String testMessage = "Test log message";
        PinguinLogger.log.log(Level.INFO, testMessage);

        try {
            String logContent = new String(Files.readAllBytes(logFile.toPath()));
            assertTrue(logContent.contains(testMessage), "Log file should contain the test message");
        } catch (IOException e) {
            fail("Failed to read log file");
        }
    }
}
