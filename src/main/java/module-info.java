module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires com.fazecast.jSerialComm;
    requires javafx.graphics;
    requires javafx.base;
    requires java.annotation;
    requires java.logging;

    exports nl.pinguinlars.pinguinterm;
    exports nl.pinguinlars.pinguinterm.keyboard;
    exports nl.pinguinlars.pinguinterm.app;
    exports nl.pinguinlars.pinguinterm.log;
    exports nl.pinguinlars.pinguinterm.serial;
}