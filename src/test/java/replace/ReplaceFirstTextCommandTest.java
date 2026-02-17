/**
 * Unit tests for the ReplaceFirstTextCommand class
 *
 * file     ReplaceFirstTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package replace;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// ReplaceFirstTextCommand test class
class ReplaceFirstTextCommandTest {

    /*
     * ReplaceFirstTextCommand class positive and negative test,
     * testing that the command correctly replaces only the first occurrence
     * of the target substring with the replacement substring in the text
     */
    @Test
    void testReplaceFirstTextCommand() {
        ReplaceFirstTextCommand replaceFirstTextCommand =
                new ReplaceFirstTextCommand("hello", "hi");
        String result = replaceFirstTextCommand.execute("hello world hello");
        assertEquals("hi world hello", result);

        result = replaceFirstTextCommand.execute("goodbye world");
        assertNotEquals("goodbye world hi", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a ReplaceFirstTextCommand instance
     */
    @Test
    void testReplaceFirstTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new ReplaceFirstTextCommand("target", "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceFirstTextCommand(" ", "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceFirstTextCommand(null, "replacement"));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceFirstTextCommand("target", " "));
        assertThrows(IllegalArgumentException.class, () ->
                new ReplaceFirstTextCommand("target", null));
    }

    @Test
    void testReplaceFirstTextCommandWithInvalidText() {
        ReplaceFirstTextCommand replaceFirstTextCommand =
                new ReplaceFirstTextCommand("hello", "hi");
        assertDoesNotThrow(() ->
                replaceFirstTextCommand.execute("hello world"));
        assertThrows(IllegalArgumentException.class, () ->
                replaceFirstTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                replaceFirstTextCommand.execute(""));
    }

}

