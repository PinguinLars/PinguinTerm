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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class App extends Application {
    public static void Launch() {
        launch();
    }

    public static void ErrorMessageLaunch() {
        ErrorMessage.Launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 750, 600);
        scene.getStylesheets().add("App.css");
        primaryStage.setTitle("Pinguin Term");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        GridPane Return = new GridPane();
        AddButtons(Return); //Just to collapse this block of code
        Return.setHgap(10);
        Return.setVgap(10);
        Return.setAlignment(Pos.CENTER);
        return Return;
    }

    private void AddButtons(GridPane aReturn) {
        aReturn.add(Button0_0(), 0, 0);
        aReturn.add(Button0_1(), 0, 1);
        aReturn.add(Button0_2(), 0, 2);
        aReturn.add(Button0_3(), 0, 3);
        aReturn.add(Button0_4(), 0, 4);
        aReturn.add(Button1_0(), 1, 0);
        aReturn.add(Button1_1(), 1, 1);
        aReturn.add(Button1_2(), 1, 2);
        aReturn.add(Button1_3(), 1, 3);
        aReturn.add(Button1_4(), 1, 4);
        aReturn.add(Button2_0(), 2, 0);
        aReturn.add(Button2_1(), 2, 1);
        aReturn.add(Button2_2(), 2, 2);
        aReturn.add(Button2_3(), 2, 3);
        aReturn.add(Button2_4(), 2, 4);
        aReturn.add(Button3_0(), 3, 0);
        aReturn.add(Button3_1(), 3, 1);
        aReturn.add(Button3_2(), 3, 2);
        aReturn.add(Button3_3(), 3, 3);
        aReturn.add(Button3_4(), 3, 4);
        aReturn.add(Button4_0(), 4, 0);
        aReturn.add(Button4_1(), 4, 1);
        aReturn.add(Button4_2(), 4, 2);
        aReturn.add(Button4_3(), 4, 3);
        aReturn.add(Button4_4(), 4, 4);
    }

    private Button Button0_0() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button0_1() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button0_2() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button0_3() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button0_4() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button1_0() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button1_1() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button1_2() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button1_3() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button1_4() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button2_0() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button2_1() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button2_2() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button2_3() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button2_4() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button3_0() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button3_1() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button3_2() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button3_3() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button3_4() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button4_0() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button4_1() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button4_2() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button4_3() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }

    private Button Button4_4() {
        Button Return = new Button("0.0");
        Return.setOnAction(e -> {
            //Hi :wave:
        });
        return Return;
    }
}

private class ErrorMessage extends Application {
    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Launch Error");
        alert.setHeaderText("No microbit connected");
        alert.setContentText("Please connect a microbit and try again.");
        alert.showAndWait();
    }

    public static void Launch() {
        launch();
    }
}