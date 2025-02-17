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
import java.util.concurrent.TimeUnit;

public class SerialController {
    public SerialPort MicroBitPort;
    ExecutorService ReadProcess = Executors.newFixedThreadPool(4);
    public volatile boolean ActiveProcess = true;
    public ArrayList<String> MessageLog = new ArrayList<>();
    static LogHandler Logger = new LogHandler(false);
    static LogHandler ErrorLogger = new LogHandler(true);

    public SerialController() {
        SerialPort[] ports = SerialPort.getCommPorts();
        final String[] knowPorts = {"mbed Serial Port"};
        for (SerialPort port : ports) {
            System.out.printf("Port %s detected%n", port.getDescriptivePortName());
            Logger.Log("Port: " + port.getDescriptivePortName());
            if (!Arrays.asList(knowPorts).contains(port.getPortDescription())) continue;
            Logger.Log("MicroBit found");
            MicroBitPort = port;
            MicroBitPort.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            break;
        }
    }

    public void SendMessage(String Message) {
        if (!(MicroBitPort != null && MicroBitPort.isOpen())) {
            ErrorLogger.Log("Port isn't open or MicroBit not detected");
            return;
        }
        byte[] MessageInBytes = Message.getBytes();
        MicroBitPort.writeBytes(MessageInBytes, MessageInBytes.length);
        Logger.Log("Send Message: " + Message);
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            ErrorLogger.Log(e.getMessage());
        }
    }

    public String Message() {
        return MessageLog.getLast();
    }

    //Please don't use in a catch or finally statement, instead use {Your object}.ReadProcess.ShutdownNow
    public void Shutdown() {
        ActiveProcess = false;
        MicroBitPort.closePort();
        ReadProcess.shutdown();
        Logger.Log("Shutting Down");
    }
}