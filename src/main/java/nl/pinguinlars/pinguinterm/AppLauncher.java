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

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AppLauncher extends Application {
    static SerialController serial = new SerialController();
    static LogHandler Logger = new LogHandler(false);
    static LogHandler ErrorLogger = new LogHandler(true);

    public static void main(String[] args) throws IOException {
        Logger.Log("Starting Application");
        if (serial.MicroBitPort == null) {
            ErrorMessage.Launch();
            ErrorLogger.Log("No MicroBit Found");
            Logger.Log("Exiting Application");
            throw new IOException("No MicroBit found");
        }
        serial.ReadProcess.submit(() -> {
            byte[] buffer = new byte[1024];
            try {
                while (serial.ActiveProcess) {
                    int numRead = serial.MicroBitPort.readBytes(buffer, buffer.length);
                    if (numRead > 0) {
                        String receivedData = new String(buffer, 0, numRead);
                        serial.MessageLog.add(receivedData);
                        Logger.Log(receivedData);
                    }
                }
            } catch (Exception e) {
                ErrorLogger.Log(e.getMessage());
            }
        });
        try {
            serial.MicroBitPort.openPort();
            launch(args);
        } catch (Exception e) {
            ErrorLogger.Log(e.getMessage());
            serial.ReadProcess.shutdownNow();
            serial.MicroBitPort.closePort();
        }
        serial.Shutdown();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 960, 540);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        VBox Return = new VBox(20, Button0_0(), Button1_0(), Button2_0(), Button3_0(), Button4_0());
        Return.setAlignment(Pos.CENTER_LEFT);
        return Return;
    }

    private void KeyboardActions(Scene scene) {
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W:
                    //Active forward.
                    break;
                default:
                    break;
            }
        });
    }

    private Button Button0_0() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }

    private Button Button1_0() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }

    private Button Button2_0() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }

    private Button Button3_0() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> {
            System.out.println("Hello");
//            SerialControllerDeprecated.SendMessage("Forward"); //Not tested
        });
        return Return;
    }

    private Button Button4_0() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }

    private Button Button0_1() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }

    private Button Button1_1() {
        Button Return = new Button("Forward");
        Return.setOnAction(evt -> System.out.println("Hello"));
        return Return;
    }
}