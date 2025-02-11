module nl.pinguinlars.pinguinterm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens nl.pinguinlars.pinguinterm to javafx.fxml;
    exports nl.pinguinlars.pinguinterm;
}