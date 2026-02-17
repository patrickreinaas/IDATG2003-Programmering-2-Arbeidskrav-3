/**
 * Unit tests for the CapitalizeWordsTextCommand class
 *
 * file     CapitalizeWordsTextCommandTest.java
 * @author  Patrick Reinås
 * @version 0.0.1
 * @since   17.02.2026
 */


package capitalize;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// CapitalizeWordsTextCommand test class
public class CapitalizeWordsTextCommandTest {

    /*
     * positive and negative test for the CapitalizeWordsTextCommand,
     * testing that the command correctly capitalizes the first letter
     * of each word in the input text
     */
    @Test
    void testCapitalizeWordsTextCommand() {
        CapitalizeWordsTextCommand capitalizeWordsTextCommand =
                new CapitalizeWordsTextCommand();
        String result = capitalizeWordsTextCommand.execute("hello world test");
        assertEquals("Hello World Test", result);

        result = capitalizeWordsTextCommand.execute("HELLO WORLD");
        assertNotEquals("hello world", result);
    }

    /*
     * Tests for invalid text input
     * when executing the CapitalizeWordsTextCommand
     */
    @Test
    void testCapitalizeWordsTextCommandWithNullText() {
        CapitalizeWordsTextCommand capitalizeWordsTextCommand =
                new CapitalizeWordsTextCommand();
        assertThrows(IllegalArgumentException.class, () ->
                capitalizeWordsTextCommand.execute(null));
    }

    @Test
    void testCapitalizeWordsTextCommandWithBlankText() {
        CapitalizeWordsTextCommand capitalizeWordsTextCommand =
                new CapitalizeWordsTextCommand();
        assertThrows(IllegalArgumentException.class, () ->
                capitalizeWordsTextCommand.execute(""));
    }

}
