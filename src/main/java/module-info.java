module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires com.fazecast.jSerialComm;
    requires javafx.graphics;
    requires javafx.base;
    requires java.logging;


    opens nl.pinguinlars.pinguinterm to javafx.fxml;
    exports nl.pinguinlars.pinguinterm;
    exports nl.pinguinlars.pinguinterm.keyboard;
    opens nl.pinguinlars.pinguinterm.keyboard to javafx.fxml;
    exports nl.pinguinlars.pinguinterm.app;
    opens nl.pinguinlars.pinguinterm.app to javafx.fxml;
    exports nl.pinguinlars.pinguinterm.log;
    opens nl.pinguinlars.pinguinterm.log to javafx.fxml;
}