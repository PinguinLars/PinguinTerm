package nl.pinguinlars.pinguinterm.keyboard;

import nl.pinguinlars.pinguinterm.serial.SerialController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

class KeyboardHandlerTest {

    private SerialController serialController;
    private KeyboardHandler keyboardHandler;

    @BeforeEach
    void setUp() {
        serialController = Mockito.mock(SerialController.class);
        keyboardHandler = new KeyboardHandler(serialController);
    }

    @Test
    void testMovementKeys() {
        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.W));
        verify(serialController, times(1)).SendMessage("Forward");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.A));
        verify(serialController, times(1)).SendMessage("Left");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.S));
        verify(serialController, times(1)).SendMessage("Back");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.D));
        verify(serialController, times(1)).SendMessage("Right");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.SA));
        verify(serialController, times(1)).SendMessage("BackLeft");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.SD));
        verify(serialController, times(1)).SendMessage("BackRight");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.WA));
        verify(serialController, times(1)).SendMessage("ForwardLeft");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.WD));
        verify(serialController, times(1)).SendMessage("ForwardRight");

        assertDoesNotThrow(() -> keyboardHandler.MovementKeys(Key.Stop));
        verify(serialController, times(1)).SendMessage("Stop");
    }

    @Test
    void testMovementKeysWithoutArguments() {
        assertDoesNotThrow(() -> keyboardHandler.MovementKeys());
        verify(serialController, times(1)).SendMessage("Stop");
    }
}
