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
import javafx.scene.control.Alert
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import javafx.stage.StageStyle

@Suppress("RedundantVisibilityModifier")
public class ErrorMessage : Application() {
    override fun start(stage: Stage?) {
        val alert = Alert(Alert.AlertType.ERROR)
        alert.initStyle(StageStyle.UNDECORATED)
        alert.title = "Launch Error"
        alert.headerText = "No microbit connected"
        alert.contentText = "Please connect a microbit and try again."
        val errorIcon = Image(javaClass.getResourceAsStream("/google_fonts/icons/error.png"))
        alert.graphic = ImageView(errorIcon)
        alert.dialogPane.stylesheets.add("ErrorMessage.css")
        alert.showAndWait()
    }
}