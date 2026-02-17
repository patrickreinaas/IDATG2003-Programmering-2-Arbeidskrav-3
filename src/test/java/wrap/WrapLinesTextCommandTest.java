/**
 * Unit tests for the WrapLinesTextCommand class
 *
 * file     WrapLinesTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// WrapLinesTextCommand test class
class WrapLinesTextCommandTest {

    /*
     * WrapLinesTextCommand class positive and negative test,
     * testing that the command correctly wraps each line
     * with specified opening and ending strings
     */
    @Test
    void testWrapLinesTextCommand() {
        WrapLinesTextCommand wrapLinesTextCommand =
                new WrapLinesTextCommand("<li>", "</li>");
        String result = wrapLinesTextCommand.execute("hello\nworld");
        assertEquals("<li>hello</li>\n<li>world</li>", result);

        result = wrapLinesTextCommand.execute("single line");
        assertNotEquals("<li>single line\n</li>", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a WrapLinesTextCommand instance
     */
    @Test
    void testWrapLinesTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new WrapLinesTextCommand("[", "]"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapLinesTextCommand(" ", "]"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapLinesTextCommand(null, "]"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapLinesTextCommand("[", " "));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapLinesTextCommand("[", null));
    }

    @Test
    void testWrapLinesTextCommandWithInvalidText() {
        WrapLinesTextCommand wrapLinesTextCommand =
                new WrapLinesTextCommand("<li>", "</li>");
        assertDoesNotThrow(() ->
                wrapLinesTextCommand.execute("hello\nworld"));
        assertThrows(IllegalArgumentException.class, () ->
                wrapLinesTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                wrapLinesTextCommand.execute(""));
    }

}
