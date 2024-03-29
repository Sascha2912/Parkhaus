package UserInput;

import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInput {
    private static final Scanner userInput = new Scanner(System.in);

    public static String getUserString(String abfrage){
        System.out.println(abfrage);
        return userInput.nextLine();
    }

    public static int getUserIntMinMax(String abfrage, int von, int bis){
        System.out.println(abfrage);
        int userIntNumber;
        while(true) {
            try {
                userIntNumber = userInput.nextInt();
                // Bedingung definieren.
                if (userIntNumber >= von && userIntNumber <= bis) {
                    return userIntNumber;
                    // Benutzerinformation beim falschen Wert.
                } else if (userIntNumber < von) {
                    System.out.println("Ihre Zahl ist zu klein.\nAuswahl nicht gefunden: ");
                } else if (userIntNumber > bis) {
                    System.out.println("Ihre Zahl ist zu groß.\nAuswahl nicht gefunden: ");
                }
            }catch(InputMismatchException ex){
                // Benutzerinformation beim falschen Datentypen.
                System.out.println("Ungültige Eingabe. Ihre Eingabe war entweder zu lang oder keine Ganzzahl.\nGeben Sie bitte eine Zahl mit maximal 9 Ziffern ein: ");
            } catch (Exception ex) {
                // Benutzerinformation bei allen weiteren Fehlern
                System.out.println("Fehler!\nBitte versuchen Sie es erneut; ");
            }finally {
                // Tastaturpuffer leeren.
                userInput.nextLine();
            }
        }
    }

    public static int getUserInt(String abfrage){
        System.out.print(abfrage);
        int userIntNumber;
        while(true) {
            try {
                userIntNumber = userInput.nextInt();
                return userIntNumber;
            }catch(InputMismatchException ex){
                System.out.println("Ungültige Eingabe. Ihre Eingabe war entweder zu lang oder keine Ganzzahl.\nGeben Sie bitte eine Zahl mit maximal 9 Ziffern ein: ");
            } catch (Exception ex) {
                System.out.println("Fehler!\nBitte versuchen Sie es erneut; ");
            }finally {
                userInput.nextLine();
            }
        }
    }

}
