module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires com.fazecast.jSerialComm;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
    requires org.controlsfx.controls;


    opens nl.pinguinlars.pinguinterm to javafx.fxml;
    exports nl.pinguinlars.pinguinterm;
}