import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {

    private final Map<Character, String> englishToMorse = new HashMap<>();
    private final Map<String, Character> morseToEnglish = new HashMap<>();

    public MorseCodeTranslator() {
        add('A', ".-");
        add('B', "-...");
        add('C', "-.-.");
        add('D', "-..");
        add('E', ".");
        add('F', "..-.");
        add('G', "--.");
        add('H', "....");
        add('I', "..");
        add('J', ".---");
        add('K', "-.-");
        add('L', ".-..");
        add('M', "--");
        add('N', "-.");
        add('O', "---");
        add('P', ".--.");
        add('Q', "--.-");
        add('R', ".-.");
        add('S', "...");
        add('T', "-");
        add('U', "..-");
        add('V', "...-");
        add('W', ".--");
        add('X', "-..-");
        add('Y', "-.--");
        add('Z', "--..");
    }

    private void add(char english, String morse) {
        englishToMorse.put(english, morse);
        morseToEnglish.put(morse, english);
    }

    // Engelska -> Morse
    // Ex: "HEJ" -> ".... . .---"
    public String toMorse(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input får inte vara null.");
        }

        input = input.trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva något.");
        }

        StringBuilder result = new StringBuilder();

        for (char letter : input.toUpperCase().toCharArray()) {

            if (letter == ' ') continue; // ord behöver ej hanteras

            String morse = englishToMorse.get(letter);

            if (morse == null) {
                throw new IllegalArgumentException("Endast bokstäver A-Z är tillåtna.");
            }

            result.append(morse).append(" ");
        }

        // Ta bort sista mellanslaget
        result.setLength(result.length() - 1);

        return result.toString();
    }

    // Morse -> Engelska
    // Ex: ".... . .---" -> "HEJ"
    public String toEnglish(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input får inte vara null.");
        }

        input = input.trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Du måste skriva något.");
        }

        String[] morseLetters = input.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String morse : morseLetters) {

            Character letter = morseToEnglish.get(morse);

            if (letter == null) {
                throw new IllegalArgumentException("Ogiltig morsekod: " + morse);
            }

            result.append(letter);
        }

        return result.toString();
    }
}