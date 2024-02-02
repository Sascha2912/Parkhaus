
import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInput {
    private static final Scanner userInput = new Scanner(System.in);

    public static String getUserString(String abfrage){
        System.out.println(abfrage);
        return userInput.nextLine();
    }

    public static int getUserInt(String abfrage, int von, int bis){
        // Benutzerinformation, welche Werte und Datentypen zulässig sind.
        System.out.println(abfrage);
        int userIntNumber;
        // Wiederholung bis zur gewünschten Eingabe.
        while(true) {
            try {
                // User-Abfrage
                userIntNumber = userInput.nextInt();
                // Bedingung definieren.
                if (userIntNumber >= von && userIntNumber <= bis) {
                    return userIntNumber;
                    // Benutzerinformation beim falschen Wert.
                } else if (userIntNumber < von) {
                    System.out.println("Ihre Zahl ist zu klein.\nGeben Sie bitte einen größere Zahl ein: ");
                } else if (userIntNumber > bis) {
                    System.out.println("Ihre Zahl ist zu groß.\nGeben Sie bitte einen kleinere Zahl ein: ");
                }
            }catch(InputMismatchException ex){
                // Benutzerinformation beim falschen Datentypen.
                System.out.println("Ungültige Eingabe. Ihre Eingabe war entweder zu lang oder keine Zahl.\nGeben Sie bitte eine Zahl mit maximal 10 Ziffern ein: ");
            } catch (Exception ex) {
                // Benutzerinformation bei allen weiteren Fehlern
                System.out.println("Fehler!\nBitte versuchen Sie es erneut; ");
            }finally {
                // Tastaturpuffer leeren.
                userInput.nextLine();
            }
        }
    }

}
