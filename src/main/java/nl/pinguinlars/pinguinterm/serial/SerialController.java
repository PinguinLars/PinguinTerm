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

package nl.pinguinlars.pinguinterm.serial;

import com.fazecast.jSerialComm.SerialPort;
import nl.pinguinlars.pinguinterm.log.Logger;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.logging.Level.SEVERE;

public class SerialController {
    private static final Logger logger = Logger.getInstance();
    public static SerialPort MicroBitPort;
    private static SerialController instance;
    public final ArrayList<String> MessageLog = new ArrayList<>();
    public final ExecutorService ReadProcess = Executors.newFixedThreadPool(4);
    public volatile boolean ActiveProcess = true;

    private SerialController() {
        SerialPort[] ports = SerialPort.getCommPorts();
        final String[] knowPorts = {"mbed Serial Port"};
        for (SerialPort port : ports) {
            logger.info(String.format("Port %s detected%n", port.getDescriptivePortName()));
            logger.fine("Port: " + port.getDescriptivePortName());
            if (!Arrays.asList(knowPorts).contains(port.getPortDescription())) continue;
            logger.info("MicroBit found at " + port.getDescriptivePortName());
            MicroBitPort = port;
            MicroBitPort.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            MicroBitPort.openPort();
            break;
        }
    }

    public static SerialController getInstance() {
        if (instance == null) {
            instance = new SerialController();
        }
        return instance;
    }

    public void SendMessage(String Message) {
        MicroBitPort.openPort();
        if (MicroBitPort == null) {
            logger.severe("Micro:bit not detected");
            return;
        } else if (!MicroBitPort.isOpen()) {
            logger.severe("Port isn't open");
            return;
        }

        Message += ";"; //Adds a ";" to the message such that the Micro:bit can process it the message
        byte[] MessageInBytes = Message.getBytes();
        MicroBitPort.writeBytes(MessageInBytes, MessageInBytes.length);
        logger.finer("Message send: " + Message);
        try {
            logger.finest("Waiting 10 milliseconds");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            logger.log(SEVERE, "Couldn't wait for 10 milliseconds", e);
        }
    }

    /**
     * Please don't use this, this is here for some reason.
     */
    @Deprecated
    public String Message() {
        return MessageLog.getLast();
    }

    /**
     * Shutdown methode for the {@link SerialController},<br>
     * but don't use this methode in a catch or finally block, instead use the ShutdownNow methode.
     */
    @PreDestroy
    public void Shutdown() {
        ActiveProcess = false;
        ReadProcess.shutdown();
        MicroBitPort.closePort();
    }

    public void ShutdownNow() {
        ReadProcess.shutdownNow();
        MicroBitPort.closePort();
    }
}