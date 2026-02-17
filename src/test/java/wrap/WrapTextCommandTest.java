/**
 * Unit tests for the WrapTextCommand class
 *
 * file     WrapTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package wrap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// WrapTextCommand test class
class WrapTextCommandTest {

    /*
     * WrapTextCommand class positive and negative test,
     * testing that the command correctly wraps text with
     * specified opening and ending strings
     */
    @Test
    void testWrapTextCommand() {
        WrapTextCommand wrapTextCommand =
                new WrapTextCommand("<p>", "</p>");
        String result = wrapTextCommand.execute("hello world");
        assertEquals("<p>hello world</p>", result);

        result = wrapTextCommand.execute("test");
        assertNotEquals("<p>test", result);
    }

    /*
     * Tests for valid and invalid parameters
     * when creating a WrapTextCommand instance
     */
    @Test
    void testWrapTextCommandWithValidText() {
        assertDoesNotThrow(() ->
                new WrapTextCommand("<div>", "</div>"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapTextCommand(" ", "</div>"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapTextCommand(null, "</div>"));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapTextCommand("<div>", " "));
        assertThrows(IllegalArgumentException.class, () ->
                new WrapTextCommand("<div>", null));
    }

    @Test
    void testWrapTextCommandWithInvalidText() {
        WrapTextCommand wrapTextCommand =
                new WrapTextCommand("<p>", "</p>");
        assertDoesNotThrow(() ->
                wrapTextCommand.execute("hello world"));
        assertThrows(IllegalArgumentException.class, () ->
                wrapTextCommand.execute(null));
        assertThrows(IllegalArgumentException.class, () ->
                wrapTextCommand.execute(""));
    }

}
