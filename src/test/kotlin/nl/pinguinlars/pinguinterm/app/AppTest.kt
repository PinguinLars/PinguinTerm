package nl.pinguinlars.pinguinterm.app

import javafx.application.Application
import javafx.stage.Stage
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.testfx.framework.junit5.ApplicationTest

class AppTest : ApplicationTest() {

    private lateinit var app: App

    @BeforeEach
    fun setUp() {
        app = App()
    }

    @Test
    fun testStart() {
        assertDoesNotThrow {
            interact {
                app.start(Stage())
            }
        }
    }
}
