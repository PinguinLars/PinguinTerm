/*
 * MIT License
 *
 * Copyright (c) 2025 PinguinLars
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package nl.pinguinlars.pinguinterm;

import nl.pinguinlars.pinguinterm.app.App;
import nl.pinguinlars.pinguinterm.app.ErrorMessage;
import nl.pinguinlars.pinguinterm.log.Logger;
import nl.pinguinlars.pinguinterm.serial.SerialController;

import static java.util.logging.Level.SEVERE;

public class Main {
    private static final SerialController serial = SerialController.getInstance();
    private static final Logger logger = Logger.getInstance();

    @SuppressWarnings({"AccessStaticViaInstance"})
    public static void main(String[] args) {
        logger.info("Starting Application");
        if (serial.MicroBitPort == null) {
            ErrorMessage.launch(ErrorMessage.class, args);
            logger.log(SEVERE, "No MicroBit Found");
            logger.info("Exiting Application");
            throw new RuntimeException("No MicroBit found");
        }
        serial.ReadProcess.submit(() -> {
            byte[] buffer = new byte[1024];
            while (serial.ActiveProcess) {
                int numRead = serial.MicroBitPort.readBytes(buffer, buffer.length);
                if (numRead > 0) {
                    String RecievedData = new String(buffer, 0, numRead);
                    logger.info("(Micro:bit) " + RecievedData);
                    serial.MessageLog.add(RecievedData);
                    logger.finest(String.format("Added %s to the MessageLog ", RecievedData)); //Might deprecate that
                }
            }
        });
        try {
            App.launch(App.class, args);
            logger.finer("Shutting down application internals");
            serial.Shutdown();
        } catch (Exception e) {
            logger.finer("Forcefully shutting down application internals");
            serial.ShutdownNow();
            logger.log(SEVERE, "Unknown exception occurred", e);
        }
        logger.info("Exiting Application");
    }
}