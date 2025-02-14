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

public class SerialController {
    final private static String[] KnowPorts = {"mbed Serial Port"};
    static SerialPort MicroBitPort;
    static ExecutorService ReadProcess = Executors.newFixedThreadPool(4);
    public static volatile boolean ActiveProcess = true;
    static ArrayList<String> MessageLog = new ArrayList<>();

    public static void PreLaunchChecks() {
        SerialPort[] ports = SerialPort.getCommPorts();
        for (SerialPort port : ports) {
            System.out.printf("Port %s detected%n", port.getDescriptivePortName());
            if (!Arrays.asList(KnowPorts).contains(port.getPortDescription())) continue;
            MicroBitPort = port;
            MicroBitPort.setComPortParameters(115200, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
            break;
        }
    }

    public static void SendMessage(String Message) {
        if (!(MicroBitPort != null && MicroBitPort.isOpen())) return;
        byte[] MessageInBytes = Message.getBytes();
        MicroBitPort.writeBytes(MessageInBytes, MessageInBytes.length);
    }

    public static String Message() {
        return MessageLog.getLast();
    }

    public static String Message(int n) {
        return MessageLog.get(n);
    }

    //Please don't use in a catch or finally statement, instead use SerialController.ReadProcess.ShutdownNow
    public static void Shutdown() {
        ActiveProcess = false;
        ReadProcess.shutdown();
    }
}