package nl.pinguinlars.pinguinterm.serial;

import com.fazecast.jSerialComm.SerialPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutorService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SerialControllerTest {

    private SerialController serialController;
    private SerialPort mockPort;

    @BeforeEach
    void setUp() {
        mockPort = Mockito.mock(SerialPort.class);
        serialController = new SerialController();
        SerialController.MicroBitPort = mockPort;
    }

    @Test
    void testSendMessage() {
        when(mockPort.isOpen()).thenReturn(true);

        assertDoesNotThrow(() -> serialController.SendMessage("TestMessage"));
        verify(mockPort, times(1)).writeBytes(any(byte[].class), anyInt());
    }

    @Test
    void testSendMessagePortNotOpen() {
        when(mockPort.isOpen()).thenReturn(false);

        assertDoesNotThrow(() -> serialController.SendMessage("TestMessage"));
        verify(mockPort, times(0)).writeBytes(any(byte[].class), anyInt());
    }

    @Test
    void testShutdown() {
        ExecutorService mockExecutorService = Mockito.mock(ExecutorService.class);
        serialController.ReadProcess = mockExecutorService;

        assertDoesNotThrow(() -> serialController.Shutdown());
        verify(mockExecutorService, times(1)).shutdown();
        verify(mockPort, times(1)).closePort();
    }

    @Test
    void testShutdownNow() {
        ExecutorService mockExecutorService = Mockito.mock(ExecutorService.class);
        serialController.ReadProcess = mockExecutorService;

        assertDoesNotThrow(() -> serialController.ShutdownNow());
        verify(mockExecutorService, times(1)).shutdownNow();
        verify(mockPort, times(1)).closePort();
    }
}
