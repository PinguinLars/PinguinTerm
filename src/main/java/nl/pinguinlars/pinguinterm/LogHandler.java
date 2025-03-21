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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogHandler {
    private static final String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH;mm;ss"));
    static final File logFile = new File("logs/PinguinTerm_" + date + ".log");
    private static final String Error = "(ERROR) ";
    static FileWriter logWriter;
    final boolean error;

    public LogHandler() {
        try {
            File parentDir = logFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            //Not going to log to the .log file on this methode, because this is the initialization log methode
        }
        this.error = false;
    }

    public LogHandler(boolean error) {
        try {
            File parentDir = logFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) parentDir.mkdirs();
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            //Not going to log to the .log file on this methode, because this is the initialization log methode
        }
        this.error = error;
    }

    public void Log(String message) {
        String time = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH;mm;ss,SSS")) + "] ";
        try {
            logWriter = new FileWriter(logFile, true);
            var lineSeparator = System.lineSeparator();
            if (error)
                logWriter.write(time + Error + message + lineSeparator); //For easy location of errors
            else logWriter.write(time + message + lineSeparator);
        } catch (IOException e) {
            e.printStackTrace();//Not going to log to the .log file on this methode, because this is the log methode
        } finally {
            try {
                if (null != logWriter) {
                    logWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();//Not going to log to the .log file on this methode, because this is the log methode
            }
        }
    }
}
