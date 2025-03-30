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


package nl.pinguinlars.pinguinterm.app

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.input.KeyEvent
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.stage.Stage
import nl.pinguinlars.pinguinterm.keyboard.Key
import nl.pinguinlars.pinguinterm.keyboard.KeyHandler
import nl.pinguinlars.pinguinterm.serial.SerialController

@Suppress( "LocalVariableName", "RedundantVisibilityModifier", "FunctionName")
public class App : Application() {
    private val buttonVSize: Double = 140.0
    private val buttonV1Size: Double = 110.0
    private val keyboard: KeyHandler = KeyHandler(SerialController.getInstance())

    override fun start(primaryStage: Stage) {
        val scene = Scene(createContents(), 750.0, 600.0)
        scene.stylesheets.add("App.css")
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyboard)
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyboard)
        primaryStage.title = "Pinguin Term"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun createContents(): Region {
        val gridPane = GridPane()
        addButtons(gridPane) //Just to collapse this block of code
        gridPane.hgap = 10.0
        gridPane.vgap = 10.0
        gridPane.alignment = Pos.CENTER
        return gridPane
    }

    private fun addButtons(gridPane: GridPane) {
        gridPane.add(button0_0(), 0, 0)
        gridPane.add(Button0_1(), 0, 1)
        gridPane.add(Button0_2(), 0, 2)
        gridPane.add(Button0_3(), 0, 3)
        gridPane.add(Button0_4(), 0, 4)
        gridPane.add(button1_0(), 1, 0)
        gridPane.add(Button1_1(), 1, 1)
        gridPane.add(Button1_2(), 1, 2)
        gridPane.add(Button1_3(), 1, 3)
        gridPane.add(Button1_4(), 1, 4)
        gridPane.add(Button2_0(), 2, 0)
        gridPane.add(Button2_1(), 2, 1)
        gridPane.add(Button2_2(), 2, 2)
        gridPane.add(Button2_3(), 2, 3)
        gridPane.add(Button2_4(), 2, 4)
        gridPane.add(Button3_0(), 3, 0)
        gridPane.add(Button3_1(), 3, 1)
        gridPane.add(Button3_2(), 3, 2)
        gridPane.add(Button3_3(), 3, 3)
        gridPane.add(Button3_4(), 3, 4)
        gridPane.add(Button4_0(), 4, 0)
        gridPane.add(Button4_1(), 4, 1)
        gridPane.add(Button4_2(), 4, 2)
        gridPane.add(Button4_3(), 4, 3)
        gridPane.add(Button4_4(), 4, 4)
    }

    private fun button0_0(): Button {
        val button0_0 = Button("0.0")
        button0_0.setPrefSize(buttonVSize, buttonV1Size)
        button0_0.id = "0_0"
        button0_0.onAction = EventHandler { e: ActionEvent? -> }
        return button0_0
    }

    private fun Button0_1(): Button {
        val button0_1 = Button("0.1")
        button0_1.setPrefSize(buttonVSize, buttonV1Size)
        button0_1.id = "0_1"
        button0_1.onAction = EventHandler { e: ActionEvent? -> }
        return button0_1
    }

    private fun Button0_2(): Button {
        val button0_2 = Button("0.2")
        button0_2.setPrefSize(buttonVSize, buttonV1Size)
        button0_2.id = "0_2"
        button0_2.onAction = EventHandler { e: ActionEvent? -> }
        return button0_2
    }

    private fun Button0_3(): Button {
        val button0_3 = Button("0.3")
        button0_3.setPrefSize(buttonVSize, buttonV1Size)
        button0_3.id = "0_3"
        button0_3.onAction = EventHandler { e: ActionEvent? -> }
        return button0_3
    }

    private fun Button0_4(): Button {
        val button0_4 = Button("0.4")
        button0_4.setPrefSize(buttonVSize, buttonV1Size)
        button0_4.id = "0_4"
        button0_4.onAction = EventHandler { e: ActionEvent? -> }
        return button0_4
    }

    private fun button1_0(): Button {
        val button1_0 = Button("1.0")
        button1_0.setPrefSize(buttonVSize, buttonV1Size)
        button1_0.id = "1_0"
        button1_0.setOnAction { e: ActionEvent? -> }
        return button1_0
    }

    private fun Button1_1(): Button {
        val button1_1 = Button("\u21D6")
        button1_1.setPrefSize(buttonVSize, buttonV1Size)
        button1_1.id = "1_1"
        button1_1.onAction = EventHandler { e: ActionEvent? -> }
        return button1_1
    }

    private fun Button1_2(): Button {
        val button1_2 = Button("\u21D0")
        button1_2.setPrefSize(buttonVSize, buttonV1Size)
        button1_2.id = "1_2"
        button1_2.onAction = EventHandler { e: ActionEvent? -> }
        return button1_2
    }

    private fun Button1_3(): Button {
        val button1_3 = Button("1.3")
        button1_3.setPrefSize(buttonVSize, buttonV1Size)
        button1_3.id = "1_3"
        button1_3.onAction = EventHandler { e: ActionEvent? -> }
        return button1_3
    }

    private fun Button1_4(): Button {
        val button1_4 = Button("1.4")
        button1_4.setPrefSize(buttonVSize, buttonV1Size)
        button1_4.id = "1_4"
        button1_4.onAction = EventHandler { e: ActionEvent? -> }
        return button1_4
    }

    private fun Button2_0(): Button {
        val button2_0 = Button("2.0")
        button2_0.setPrefSize(buttonVSize, buttonV1Size)
        button2_0.id = "2_0"
        button2_0.onAction = EventHandler { e: ActionEvent? -> }
        return button2_0
    }

    private fun Button2_1(): Button {
        val button2_1 = Button("\u21D1")
        button2_1.setPrefSize(buttonVSize, buttonV1Size)
        button2_1.id = "2_1"
        button2_1.onAction = EventHandler { e: ActionEvent? ->
            keyboard.MovementKeys(Key.W)
        }
        return button2_1
    }

    private fun Button2_2(): Button {
        val button2_2 = Button("\u20DD")
        button2_2.setPrefSize(buttonVSize, buttonV1Size)
        button2_2.id = "2_2"
        button2_2.onAction = EventHandler { e: ActionEvent? -> }
        return button2_2
    }

    private fun Button2_3(): Button {
        val button2_3 = Button("\u21D3")
        button2_3.setPrefSize(buttonVSize, buttonV1Size)
        button2_3.id = "2_3"
        button2_3.onAction = EventHandler { e: ActionEvent? -> }
        return button2_3
    }

    private fun Button2_4(): Button {
        val button2_4 = Button("2.4")
        button2_4.setPrefSize(buttonVSize, buttonV1Size)
        button2_4.id = "2_4"
        button2_4.onAction = EventHandler { e: ActionEvent? -> }
        return button2_4
    }

    private fun Button3_0(): Button {
        val button3_0 = Button("3.0")
        button3_0.setPrefSize(buttonVSize, buttonV1Size)
        button3_0.id = "3_0"
        button3_0.onAction = EventHandler { e: ActionEvent? -> }
        return button3_0
    }

    private fun Button3_1(): Button {
        val button3_1 = Button("\u21D7")
        button3_1.setPrefSize(buttonVSize, buttonV1Size)
        button3_1.id = "3_1"
        button3_1.onAction = EventHandler { e: ActionEvent? -> }
        return button3_1
    }

    private fun Button3_2(): Button {
        val button3_2 = Button("\u21D2")
        button3_2.setPrefSize(buttonVSize, buttonV1Size)
        button3_2.id = "3_2"
        button3_2.onAction = EventHandler { e: ActionEvent? -> }
        return button3_2
    }

    private fun Button3_3(): Button {
        val button3_3 = Button("3.3")
        button3_3.setPrefSize(buttonVSize, buttonV1Size)
        button3_3.id = "3_3"
        button3_3.onAction = EventHandler { e: ActionEvent? -> }
        return button3_3
    }

    private fun Button3_4(): Button {
        val button3_4 = Button("3.4")
        button3_4.setPrefSize(buttonVSize, buttonV1Size)
        button3_4.id = "3_4"
        button3_4.onAction = EventHandler { e: ActionEvent? -> }
        return button3_4
    }

    private fun Button4_0(): Button {
        val button4_0 = Button("4.0")
        button4_0.setPrefSize(buttonVSize, buttonV1Size)
        button4_0.id = "4_0"
        button4_0.onAction = EventHandler { e: ActionEvent? -> }
        return button4_0
    }

    private fun Button4_1(): Button {
        val button4_1 = Button("4.1")
        button4_1.setPrefSize(buttonVSize, buttonV1Size)
        button4_1.id = "4_1"
        button4_1.onAction = EventHandler { e: ActionEvent? -> }
        return button4_1
    }

    private fun Button4_2(): Button {
        val button4_2 = Button("4.2")
        button4_2.setPrefSize(buttonVSize, buttonV1Size)
        button4_2.id = "4_2"
        button4_2.onAction = EventHandler { e: ActionEvent? -> }
        return button4_2
    }

    private fun Button4_3(): Button {
        val button4_3 = Button("4.3")
        button4_3.setPrefSize(buttonVSize, buttonV1Size)
        button4_3.id = "4_3"
        button4_3.onAction = EventHandler { e: ActionEvent? -> }
        return button4_3
    }

    private fun Button4_4(): Button {
        val button4_4 = Button("4.4")
        button4_4.setPrefSize(buttonVSize, buttonV1Size)
        button4_4.id = "4_4"
        button4_4.onAction = EventHandler { e: ActionEvent? -> }
        return button4_4
    }
}