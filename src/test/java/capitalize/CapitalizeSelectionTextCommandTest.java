/**
 * Unit tests for the CapitalizeSelectionTextCommand class
 *
 * file     CapitalizeSelectionTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CapitalizeSelectionTextCommand test class
class CapitalizeSelectionTextCommandTest{

    /*
     * positive and negative test for the CapitalizeSelectionCommand,
     * testing that the command correctly capitalizes the first letter
     * of the specified selection text in the input text
     */
    @Test
    void testCapitalizeSelectionTextCommand() {
        CapitalizeSelectionTextCommand capitalizeSelectionTextCommand =
                new CapitalizeSelectionTextCommand("hello");
        String result = capitalizeSelectionTextCommand.execute("hello world");
        assertEquals("Hello world", result);

        result = capitalizeSelectionTextCommand.execute("Hello World");
        assertNotEquals("hello world", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a CapitalizeSelectionTextCommand instance
     */
    @Test
    void testCapitalizeSelectionTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new CapitalizeSelectionTextCommand("validText"));
        assertThrows(IllegalArgumentException.class, () ->
                new CapitalizeSelectionTextCommand(" "));
        assertThrows(IllegalArgumentException.class, () ->
                new CapitalizeSelectionTextCommand(null));
        }


    @Test
    void testCapitalizeSelectionTextCommandWithInvalidText() {
        CapitalizeSelectionTextCommand capitalizeSelectionTextCommand =
                new CapitalizeSelectionTextCommand("hello");
        assertDoesNotThrow(() ->
                capitalizeSelectionTextCommand.execute("hello world"));
        assertThrows(IllegalArgumentException.class, () ->
                capitalizeSelectionTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                capitalizeSelectionTextCommand.execute(""));
     }

}
