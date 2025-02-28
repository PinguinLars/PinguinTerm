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

public class KeyboardHandler {
    private static final LogHandler Logger = new LogHandler(false);
    private static final LogHandler ErrorLogger = new LogHandler(true);

    public static void MovementKeys(String Key) {
        Key = Key.toUpperCase();
        switch (Key) {
            case "A" -> Main.serial.SendMessage("Left");
            case "D" -> Main.serial.SendMessage("Right");
            case "S" -> Main.serial.SendMessage("Back");
            case "SA" -> Main.serial.SendMessage("BackLeft");
            case "SD" -> Main.serial.SendMessage("BackRight");
            case "W" -> Main.serial.SendMessage("Forward");
            case "WA" -> Main.serial.SendMessage("ForwardLeft");
            case "WD" -> Main.serial.SendMessage("ForwardRight");
            case "STOP" -> Main.serial.SendMessage("Stop");
            default -> {
                System.out.println("Invalid Statement Given");
                ErrorLogger.Log("Invalid Statement Given");
                return;
            }
        }
        Logger.Log("Key \"" + Key + "\" Pressed");
    }

    public static void MovementKeys() {
        Main.serial.SendMessage("Stop");
    }

    /*static void KeyHandler(KeyEvent key, Button button) {
        if (key.getCode().toString().equalsIgnoreCase("w")) {
            button.setStyle("-fx-background-color: aqua");
            MovementKeys("w");
        }
    }*/
}