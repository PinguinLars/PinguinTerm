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

public class Main {
    static SerialController serial = new SerialController();
    static LogHandler Logger = new LogHandler(false);
    static LogHandler ErrorLogger = new LogHandler(true);

    public static void main(String[] args) {
//        Logger.Log("Starting Application");
//        if (serial.MicroBitPort == null) {
//            ErrorMessage.Launch();
//            ErrorLogger.Log("No MicroBit Found");
//            Logger.Log("Exiting Application");
//            throw new RuntimeException("No MicroBit found");
//        }
//        serial.ReadProcess.submit(() -> {
//            byte[] buffer = new byte[1024];
//            try {
//                while (serial.ActiveProcess) {
//                    int numRead = serial.MicroBitPort.readBytes(buffer, buffer.length);
//                    if (numRead > 0) {
//                        String receivedData = new String(buffer, 0, numRead);
//                        serial.MessageLog.add(receivedData);
//                        Logger.Log(receivedData);
//                        Thread.sleep(10);
//                    }
//                }
//            } catch (Exception e) {
//                ErrorLogger.Log(e.getMessage());
//            }
//        });
//        try {
//            serial.MicroBitPort.openPort();
            App.Launch();
//        } catch (Exception e) {
//            serial.ReadProcess.shutdownNow();
//            serial.MicroBitPort.closePort();
//            ErrorLogger.Log(e.getMessage());
//        }
//        serial.Shutdown();
    }
}