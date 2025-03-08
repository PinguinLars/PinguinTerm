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

package nl.pinguinlars.pinguinterm.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import nl.pinguinlars.pinguinterm.Main;
import nl.pinguinlars.pinguinterm.keyboard.KeyHandler;
import nl.pinguinlars.pinguinterm.keyboard.KeyboardHandler;

import static nl.pinguinlars.pinguinterm.keyboard.Key.W;

//Statement lambda's let me add more logic to them later on. //PinguinLars
@SuppressWarnings("CodeBlock2Expr")
public class App extends Application {
    private static final int ButtonVSize = 140, ButtonV1Size = 110;
    private static final KeyboardHandler keyboard = new KeyboardHandler(Main.serial);
    private static final KeyHandler keyHandler = new KeyHandler(Main.serial);

    public static void Launch() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createContents(), 750, 600);
        scene.getStylesheets().add("App.css");
        scene.addEventFilter(KeyEvent.KEY_PRESSED,keyHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED,keyHandler);
        primaryStage.setTitle("Pinguin Term");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Region createContents() {
        GridPane gridPane = new GridPane();
        AddButtons(gridPane); //Just to collapse this block of code
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private void AddButtons(GridPane gridPane) {
        gridPane.add(Button0_0(), 0, 0);
        gridPane.add(Button0_1(), 0, 1);
        gridPane.add(Button0_2(), 0, 2);
        gridPane.add(Button0_3(), 0, 3);
        gridPane.add(Button0_4(), 0, 4);
        gridPane.add(Button1_0(), 1, 0);
        gridPane.add(Button1_1(), 1, 1);
        gridPane.add(Button1_2(), 1, 2);
        gridPane.add(Button1_3(), 1, 3);
        gridPane.add(Button1_4(), 1, 4);
        gridPane.add(Button2_0(), 2, 0);
        gridPane.add(Button2_1(), 2, 1);
        gridPane.add(Button2_2(), 2, 2);
        gridPane.add(Button2_3(), 2, 3);
        gridPane.add(Button2_4(), 2, 4);
        gridPane.add(Button3_0(), 3, 0);
        gridPane.add(Button3_1(), 3, 1);
        gridPane.add(Button3_2(), 3, 2);
        gridPane.add(Button3_3(), 3, 3);
        gridPane.add(Button3_4(), 3, 4);
        gridPane.add(Button4_0(), 4, 0);
        gridPane.add(Button4_1(), 4, 1);
        gridPane.add(Button4_2(), 4, 2);
        gridPane.add(Button4_3(), 4, 3);
        gridPane.add(Button4_4(), 4, 4);
    }

    @SuppressWarnings("StatementLambda")
    private Button Button0_0() {
        Button button0_0 = new Button("0.0");
        button0_0.setPrefSize(ButtonVSize, ButtonV1Size);
        button0_0.setId("0_0");
        button0_0.setOnAction(e -> {
            //Hi :wave:
        });
        return button0_0;
    }

    private Button Button0_1() {
        Button button0_1 = new Button("0.1");
        button0_1.setPrefSize(ButtonVSize, ButtonV1Size);
        button0_1.setId("0_1");
        button0_1.setOnAction(e -> {
            //Hi :wave:
        });
        return button0_1;
    }

    private Button Button0_2() {
        Button button0_2 = new Button("0.2");
        button0_2.setPrefSize(ButtonVSize, ButtonV1Size);
        button0_2.setId("0_2");
        button0_2.setOnAction(e -> {
            //Hi :wave:
        });
        return button0_2;
    }

    private Button Button0_3() {
        Button button0_3 = new Button("0.3");
        button0_3.setPrefSize(ButtonVSize, ButtonV1Size);
        button0_3.setId("0_3");
        button0_3.setOnAction(e -> {
            //Hi :wave:
        });
        return button0_3;
    }

    private Button Button0_4() {
        Button button0_4 = new Button("0.4");
        button0_4.setPrefSize(ButtonVSize, ButtonV1Size);
        button0_4.setId("0_4");
        button0_4.setOnAction(e -> {
            //Hi :wave:
        });
        return button0_4;
    }

    private Button Button1_0() {
        Button button1_0 = new Button("1.0");
        button1_0.setPrefSize(ButtonVSize, ButtonV1Size);
        button1_0.setId("1_0");
        button1_0.setOnAction(e -> {
            //Hi :wave:
        });
        return button1_0;
    }

    private Button Button1_1() {
        Button button1_1 = new Button("\u21D6");
        button1_1.setPrefSize(ButtonVSize, ButtonV1Size);
        button1_1.setId("1_1");
        button1_1.setOnAction(e -> {
            //Hi :wave:
        });
        return button1_1;
    }

    private Button Button1_2() {
        Button button1_2 = new Button("\u21D0");
        button1_2.setPrefSize(ButtonVSize, ButtonV1Size);
        button1_2.setId("1_2");
        button1_2.setOnAction(e -> {
            //Hi :wave:
        });
        return button1_2;
    }

    private Button Button1_3() {
        Button button1_3 = new Button("1.3");
        button1_3.setPrefSize(ButtonVSize, ButtonV1Size);
        button1_3.setId("1_3");
        button1_3.setOnAction(e -> {
            //Hi :wave:
        });
        return button1_3;
    }

    private Button Button1_4() {
        Button button1_4 = new Button("1.4");
        button1_4.setPrefSize(ButtonVSize, ButtonV1Size);
        button1_4.setId("1_4");
        button1_4.setOnAction(e -> {
            //Hi :wave:
        });
        return button1_4;
    }

    private Button Button2_0() {
        Button button2_0 = new Button("2.0");
        button2_0.setPrefSize(ButtonVSize, ButtonV1Size);
        button2_0.setId("2_0");
        button2_0.setOnAction(e -> {
            //Hi :wave:
        });
        return button2_0;
    }

    private Button Button2_1() {
        Button button2_1 = new Button("\u21D1");
        button2_1.setPrefSize(ButtonVSize, ButtonV1Size);
        button2_1.setId("2_1");
        button2_1.setOnAction(e -> {
            keyboard.MovementKeys(W);
        });
        return button2_1;
    }

    private Button Button2_2() {
        Button button2_2 = new Button("\u20DD");
        button2_2.setPrefSize(ButtonVSize, ButtonV1Size);
        button2_2.setId("2_2");
        button2_2.setOnAction(e -> {
            //Hi :wave:
        });
        return button2_2;
    }

    private Button Button2_3() {
        Button button2_3 = new Button("\u21D3");
        button2_3.setPrefSize(ButtonVSize, ButtonV1Size);
        button2_3.setId("2_3");
        button2_3.setOnAction(e -> {
            //Hi :wave:
        });
        return button2_3;
    }

    private Button Button2_4() {
        Button button2_4 = new Button("2.4");
        button2_4.setPrefSize(ButtonVSize, ButtonV1Size);
        button2_4.setId("2_4");
        button2_4.setOnAction(e -> {
            //Hi :wave:
        });
        return button2_4;
    }

    private Button Button3_0() {
        Button button3_0 = new Button("3.0");
        button3_0.setPrefSize(ButtonVSize, ButtonV1Size);
        button3_0.setId("3_0");
        button3_0.setOnAction(e -> {
            //Hi :wave:
        });
        return button3_0;
    }

    private Button Button3_1() {
        Button button3_1 = new Button("\u21D7");
        button3_1.setPrefSize(ButtonVSize, ButtonV1Size);
        button3_1.setId("3_1");
        button3_1.setOnAction(e -> {
            //Hi :wave:
        });
        return button3_1;
    }

    private Button Button3_2() {
        Button button3_2 = new Button("\u21D2");
        button3_2.setPrefSize(ButtonVSize, ButtonV1Size);
        button3_2.setId("3_2");
        button3_2.setOnAction(e -> {
            //Hi :wave:
        });
        return button3_2;
    }

    private Button Button3_3() {
        Button button3_3 = new Button("3.3");
        button3_3.setPrefSize(ButtonVSize, ButtonV1Size);
        button3_3.setId("3_3");
        button3_3.setOnAction(e -> {
            //Hi :wave:
        });
        return button3_3;
    }

    private Button Button3_4() {
        Button button3_4 = new Button("3.4");
        button3_4.setPrefSize(ButtonVSize, ButtonV1Size);
        button3_4.setId("3_4");
        button3_4.setOnAction(e -> {
            //Hi :wave:
        });
        return button3_4;
    }

    private Button Button4_0() {
        Button button4_0 = new Button("4.0");
        button4_0.setPrefSize(ButtonVSize, ButtonV1Size);
        button4_0.setId("4_0");
        button4_0.setOnAction(e -> {
            //Hi :wave:
        });
        return button4_0;
    }

    private Button Button4_1() {
        Button button4_1 = new Button("4.1");
        button4_1.setPrefSize(ButtonVSize, ButtonV1Size);
        button4_1.setId("4_1");
        button4_1.setOnAction(e -> {
            //Hi :wave:
        });
        return button4_1;
    }

    private Button Button4_2() {
        Button button4_2 = new Button("4.2");
        button4_2.setPrefSize(ButtonVSize, ButtonV1Size);
        button4_2.setId("4_2");
        button4_2.setOnAction(e -> {
            //Hi :wave:
        });
        return button4_2;
    }

    private Button Button4_3() {
        Button button4_3 = new Button("4.3");
        button4_3.setPrefSize(ButtonVSize, ButtonV1Size);
        button4_3.setId("4_3");
        button4_3.setOnAction(e -> {
            //Hi :wave:
        });
        return button4_3;
    }

    private Button Button4_4() {
        Button button4_4 = new Button("4.4");
        button4_4.setPrefSize(ButtonVSize, ButtonV1Size);
        button4_4.setId("4_4");
        button4_4.setOnAction(e -> {
            //Hi :wave:
        });
        return button4_4;
    }
}