/**
 * Unit tests for the CapitalizeTextCommand class
 *
 * file     CapitalizeTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CapitalizeTextCommandTest {

    /*
     * positive and negative test for the CapitalizeTextCommand,
     * testing that the command correctly capitalizes the first letter
     * of the input text
     */
    @Test
    void testCapitalizeTextCommand() {
        CapitalizeTextCommand capitalizeTextCommand = new CapitalizeTextCommand();
        String result = capitalizeTextCommand.execute("hello world");
        assertEquals("Hello world", result);

        result = capitalizeTextCommand.execute("Hello World");
        assertNotEquals("hello world", result);
    }

    /*
     * Tests for invalid text input
     * when executing the CapitalizeTextCommand
     */
    @Test
    void testCapitalizeTextCommandWithNullText() {
        CapitalizeTextCommand capitalizeTextCommand = new CapitalizeTextCommand();
        assertThrows(IllegalArgumentException.class, () -> capitalizeTextCommand.execute(null));
    }

    @Test
    void testCapitalizeTextCommandWithBlankText() {
        CapitalizeTextCommand capitalizeTextCommand = new CapitalizeTextCommand();
        assertThrows(IllegalArgumentException.class, () -> capitalizeTextCommand.execute(""));
    }
}
