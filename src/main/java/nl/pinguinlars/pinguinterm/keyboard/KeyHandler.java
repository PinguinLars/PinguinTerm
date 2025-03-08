package nl.pinguinlars.pinguinterm.keyboard;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import nl.pinguinlars.pinguinterm.SerialController;

import java.util.HashSet;
import java.util.Set;

import static nl.pinguinlars.pinguinterm.keyboard.Key.*;

public class KeyHandler extends KeyboardHandler implements EventHandler<KeyEvent> {
    public final Set<KeyCode> pressedKeys = new HashSet<>();

    public KeyHandler(SerialController serial) {
        super(serial);
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getEventType() == KeyEvent.KEY_PRESSED) pressedKeys.add(keyEvent.getCode());
        else if (keyEvent.getEventType() == KeyEvent.KEY_RELEASED) pressedKeys.remove(keyEvent.getCode());

        if (isPressed(W)) super.MovementKeys(W);
        else if (isPressed(A)) super.MovementKeys(A);
        else if (isPressed(S)) super.MovementKeys(S);
        else if (isPressed(D)) super.MovementKeys(D);
    }

    private boolean isPressed(Key key) {
        KeyCode keyCode; //Manual cast, because I don't like automatically converting an enum to a different enum
        if (key == Key.A) keyCode = KeyCode.A;
        else if (key == Key.D) keyCode = KeyCode.D;
        else if (key == Key.S) keyCode = KeyCode.S;
        else if (key == Key.W) keyCode = KeyCode.W;
        else keyCode = null;

        return isPressed(keyCode);
    }

    private boolean isPressed(KeyCode keyCode) {
        return pressedKeys.contains(keyCode);
    }
}