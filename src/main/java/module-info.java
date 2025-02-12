module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.fazecast.jSerialComm;

    opens nl.pinguinlars.pinguinterm to javafx.fxml;
    exports nl.pinguinlars.pinguinterm;
    exports nl.pinguinlars.pinguinterm.serial;
    opens nl.pinguinlars.pinguinterm.serial to javafx.fxml;
}