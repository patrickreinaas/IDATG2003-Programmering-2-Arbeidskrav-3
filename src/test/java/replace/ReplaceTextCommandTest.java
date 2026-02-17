/**
 * Unit tests for the ReplaceTextCommand class
 *
 * file     ReplaceTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package replace;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// ReplaceTextCommand test class
class ReplaceTextCommandTest {

    /*
     * positive and negative test for the ReplaceTextCommand,
     * testing that the command correctly replaces all occurrences
     * of the target substring with the replacement substring in the text
     */
    @Test
    void testReplaceTextCommand() {
        ReplaceTextCommand replaceTextCommand =
                new ReplaceTextCommand("hello", "hi");
        String result = replaceTextCommand.execute("hello world hello");
        assertEquals("hi world hi", result);

        result = replaceTextCommand.execute("goodbye world");
        assertNotEquals("goodbye world hi", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a ReplaceTextCommand instance
     */
    @Test
    void testReplaceTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new ReplaceTextCommand("target", "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceTextCommand(" ", "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceTextCommand(null, "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceTextCommand("target", " "));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceTextCommand("target", null));
    }

    @Test
    void testReplaceTextCommandWithInvalidText() {
        ReplaceTextCommand replaceTextCommand =
                new ReplaceTextCommand("hello", "hi");
        assertDoesNotThrow(() ->
                replaceTextCommand.execute("hello world"));
        assertThrows(IllegalArgumentException.class, () ->
                replaceTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                replaceTextCommand.execute(""));
    }

}
