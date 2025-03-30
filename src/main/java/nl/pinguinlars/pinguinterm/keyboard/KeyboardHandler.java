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

package nl.pinguinlars.pinguinterm.keyboard;

import nl.pinguinlars.pinguinterm.log.Logger;
import nl.pinguinlars.pinguinterm.serial.SerialController;

import static java.util.logging.Level.SEVERE;

public class KeyboardHandler {
    private static final Logger logger = Logger.getInstance();
    private final SerialController serial;

    public KeyboardHandler(SerialController serial) {
        this.serial = serial;
    }

    public void MovementKeys(Key key) {
        switch (key) {
            case A -> serial.SendMessage("Left");
            case D -> serial.SendMessage("Right");
            case S -> serial.SendMessage("Back");
            case SA -> serial.SendMessage("BackLeft");
            case SD -> serial.SendMessage("BackRight");
            case W -> serial.SendMessage("Forward");
            case WA -> serial.SendMessage("ForwardLeft");
            case WD -> serial.SendMessage("ForwardRight");
            case Stop -> serial.SendMessage("Stop");
            default -> {
                System.out.println("Invalid Statement Given");
                logger.log(SEVERE, "Invalid Statement Given");
                return;
            }
        }
        logger.finer("Key \"" + key + "\" Pressed");
    }

    @SuppressWarnings("unused") //I don't know, I may use this later //PinguinLars
    public void MovementKeys() {
        logger.finer("Methode \"MovementKeys\" triggered without arguments");
        serial.SendMessage("Stop");
    }
}