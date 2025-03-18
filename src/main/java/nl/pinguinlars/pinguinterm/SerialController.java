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

import com.fazecast.jSerialComm.SerialPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.logging.Level.SEVERE;
import static nl.pinguinlars.pinguinterm.log.PinguinLogger.log;

public class SerialController {
    public SerialPort MicroBitPort;
    public volatile boolean ActiveProcess = true;
    public final ArrayList<String> MessageLog = new ArrayList<>();
    final ExecutorService ReadProcess = Executors.newFixedThreadPool(4);

    public SerialController() {
        SerialPort[] ports = SerialPort.getCommPorts();
        final String[] knowPorts = {"mbed Serial Port"};
        for (SerialPort port : ports) {
            log.info(String.format("Port %s detected%n", port.getDescriptivePortName()));
            log.fine("Port: " + port.getDescriptivePortName());
            if (!Arrays.asList(knowPorts).contains(port.getPortDescription())) continue;
            log.info("MicroBit found at " + port.getDescriptivePortName());
            MicroBitPort = port;
            MicroBitPort.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            break;
        }
    }

    public void SendMessage(String Message) {
        if (!(MicroBitPort != null && MicroBitPort.isOpen())) {
            if (MicroBitPort == null) {
                log.severe("Micro:bit not detected");
            } else if (!MicroBitPort.isOpen()) {
                log.severe("Port isn't open");
            }
            return;
        }
        byte[] MessageInBytes = Message.getBytes();
        MicroBitPort.writeBytes(MessageInBytes, MessageInBytes.length);
        log.finer("Message send: " + Message);
        try {
            log.finest("Waiting 10 milliseconds");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            log.log(SEVERE,"Couldn't wait for 10 milliseconds", e);
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