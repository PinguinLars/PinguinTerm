package nl.pinguinlars.pinguinterm.keyboard;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import nl.pinguinlars.pinguinterm.serial.SerialController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class KeyHandlerTest {

    private SerialController serialController;
    private KeyHandler keyHandler;

    @BeforeEach
    void setUp() {
        serialController = Mockito.mock(SerialController.class);
        keyHandler = new KeyHandler(serialController);
    }

    @Test
    void testHandleKeyPress() {
        KeyEvent keyEventW = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.W, false, false, false, false);
        KeyEvent keyEventA = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.A, false, false, false, false);
        KeyEvent keyEventS = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        KeyEvent keyEventD = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.D, false, false, false, false);

        assertDoesNotThrow(() -> keyHandler.handle(keyEventW));
        verify(serialController, times(1)).SendMessage("Forward");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventA));
        verify(serialController, times(1)).SendMessage("Left");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventS));
        verify(serialController, times(1)).SendMessage("Back");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventD));
        verify(serialController, times(1)).SendMessage("Right");
    }

    @Test
    void testHandleKeyRelease() {
        KeyEvent keyEventW = new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.W, false, false, false, false);
        KeyEvent keyEventA = new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.A, false, false, false, false);
        KeyEvent keyEventS = new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.S, false, false, false, false);
        KeyEvent keyEventD = new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.D, false, false, false, false);

        assertDoesNotThrow(() -> keyHandler.handle(keyEventW));
        verify(serialController, times(0)).SendMessage("Forward");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventA));
        verify(serialController, times(0)).SendMessage("Left");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventS));
        verify(serialController, times(0)).SendMessage("Back");

        assertDoesNotThrow(() -> keyHandler.handle(keyEventD));
        verify(serialController, times(0)).SendMessage("Right");
    }
}
