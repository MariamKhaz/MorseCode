import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MorseCodeTranslator translator = new MorseCodeTranslator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Välj läge:");
        System.out.println("1) Engelska -> Morse");
        System.out.println("2) Morse -> Engelska");
        System.out.print("Val: ");

        String choice = sc.nextLine().trim();

        System.out.println("Skriv in text:");
        String input = sc.nextLine();

        try {
            if (choice.equals("1")) {
                System.out.println("Morse:");
                System.out.println(translator.toMorse(input));
            } else if (choice.equals("2")) {
                System.out.println("Engelska:");
                System.out.println(translator.toEnglish(input));
            } else {
                System.out.println("Ogiltigt val.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }
}
