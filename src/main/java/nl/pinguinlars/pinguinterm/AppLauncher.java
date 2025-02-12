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

public class AppLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        VBox results = new VBox(20, Button0_0());
        results.setAlignment(Pos.CENTER);
        return results;
    }

    private Button Button0_0() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button1_0() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button2_0() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button3_0() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button4_0() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button0_1() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }

    private Button Button1_1() {
        Button results = new Button("Forward");
        results.setOnAction(evt -> System.out.println("Hello"));
        return results;
    }
}