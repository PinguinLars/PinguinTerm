module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires com.fazecast.jSerialComm;

    opens nl.pinguinlars.pinguinterm to javafx.fxml;
    exports nl.pinguinlars.pinguinterm;
}