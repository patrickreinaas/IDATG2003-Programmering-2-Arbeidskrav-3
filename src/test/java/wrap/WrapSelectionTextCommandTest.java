/**
 * Unit tests for the WrapSelectionTextCommand class
 *
 * file     WrapSelectionTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// WrapSelectionTextCommand test class
class WrapSelectionTextCommandTest {

    /*
     * WrapSelectionTextCommand class positive and negative test,
     * testing that the command correctly wraps all occurrences
     * of the selected word with specified opening and ending strings
     */
    @Test
    void testWrapSelectionTextCommand() {
        WrapSelectionTextCommand wrapSelectionTextCommand =
                new WrapSelectionTextCommand("<strong>", "</strong>", "world");
        String result =
                wrapSelectionTextCommand.execute("hello world");
        assertEquals("hello <strong>world</strong>", result);

        result = wrapSelectionTextCommand.execute("hello world world");
        assertNotEquals("hello world <strong>world</strong>", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a WrapSelectionTextCommand instance
     */
    @Test
    void testWrapSelectionTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new WrapSelectionTextCommand("[", "]", "word"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand(" ", "]", "word"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand(null, "]", "word"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand("[", " ", "word"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand("[", null, "word"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand("[", "]", " "));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapSelectionTextCommand("[", "]", null));
    }

    @Test
    void testWrapSelectionTextCommandWithInvalidText() {
        WrapSelectionTextCommand wrapSelectionTextCommand =
                new WrapSelectionTextCommand("<em>", "</em>", "hello");
        assertDoesNotThrow(() ->
                wrapSelectionTextCommand.execute("hello world"));
        assertThrows(IllegalArgumentException.class, () ->
                wrapSelectionTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                wrapSelectionTextCommand.execute(""));
    }

}
