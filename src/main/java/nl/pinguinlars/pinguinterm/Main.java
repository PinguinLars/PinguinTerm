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

import static java.util.logging.Level.SEVERE;
import static nl.pinguinlars.pinguinterm.log.PinguinLogger.log;

public class Main {
    public static final SerialController serial = new SerialController();

    @SuppressWarnings("BusyWait") //Needed to not overload cpu and ram, but the warning isn't needed.
    public static void main(String[] args) {
        log.info("Starting Application");
        if (serial.MicroBitPort == null) {
            ErrorMessage.Launch();
            log.log(SEVERE, "No MicroBit Found");
            log.info("Exiting Application");
            throw new RuntimeException("No MicroBit found");
        }
        serial.ReadProcess.submit(() -> {
            byte[] buffer = new byte[4096];
            try {
                while (serial.ActiveProcess) {
                    int numRead = serial.MicroBitPort.readBytes(buffer, buffer.length);
                    if (numRead > 0) {
                        String receivedData = new String(buffer, 0, numRead);
                        log.info("{Micro:bit} " + receivedData);
                        serial.MessageLog.add(receivedData);
                        log.finest(String.format("Added %s to the MessageLog ", receivedData)); //Might deprecate that
                        Thread.sleep(10);
                    }
                }
            } catch (Exception e) {
                log.log(SEVERE, "Unknown exception occurred", e);
            }
        });
        try {
            serial.MicroBitPort.openPort();
            App.Launch();
            log.finer("Shutting down application internals");
            serial.Shutdown();
        } catch (Exception e) {
            log.finer("Forcefully shutting down application internals");
            serial.ShutdownNow();
            log.log(SEVERE, "Unknown exception occurred", e);
        }
        log.info("Exiting Application");
    }
}