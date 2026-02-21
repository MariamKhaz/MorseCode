import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TranslatorTest {

    private final MorseCodeTranslator translator = new MorseCodeTranslator();

    @Test
    void morseToEnglish_testing() {
        assertEquals("HEJ", translator.toEnglish(".... . .---"));
    }

    @Test
    void englishToMorse_testing() {
        assertEquals(".... . .---", translator.toMorse("HEJ"));
    }

    @Test
    void morseToEnglish_HELLOWORLD() {
        assertEquals("HELLOWORLD",
                translator.toEnglish(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
    }

    @Test
    void englishToMorse_ignoresSpaces() {
        assertEquals(".... . .-.. .-.. --- .-- --- .-. .-.. -..",
                translator.toMorse("HELLO WORLD"));
    }

    @Test
    void englishToMorse_unknownThrow() {
        assertThrows(IllegalArgumentException.class, () -> translator.toMorse("HEJ!"));
    }

    @Test
    void morseToEnglish_unknownCode_throws() {
        assertThrows(IllegalArgumentException.class, () -> translator.toEnglish(".... . ..--"));
    }
}