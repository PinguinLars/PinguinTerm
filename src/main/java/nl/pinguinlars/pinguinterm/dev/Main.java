package nl.pinguinlars.pinguinterm.dev;

import nl.pinguinlars.pinguinterm.app.App;

// It is a subclass of pinguinterm/Main.java such that it is easier to know that this is a dev implementation of pinguinterm/Main.java
@SuppressWarnings("SpellCheckingInspection")
public class Main extends nl.pinguinlars.pinguinterm.Main {
    public static void main(String[] args) {
        App.Launch();
    }
}