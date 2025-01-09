import java.util.ArrayList;
import java.util.Scanner;

public class Luchthaven {


    public static void main(String[] args) {

    ArrayList<Personeel> personeel = new ArrayList<Personeel>();
    ArrayList<Passagier> passagiers = new ArrayList<Passagier>();
    ArrayList<Vliegtuig> vluchten = new ArrayList<Vliegtuig>();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while(!exit){


    System.out.println("a) nieuwe passagier \nb) nieuw ticket \nc) nieuwe vlucht \nd) voeg personeel toe aan vlucht \ne) boarding passagiers \nf) exit");
    System.out.println("Kies 1 van de bovenstaande opties door het nummer van de optie in te geven en op enter te klikken");
    String keuze = scanner.nextLine();
                switch (keuze){

                    case "a":
                        System.out.print("geef het gewicht van de bagage: ");
                        int gewicht = scanner.nextInt();
                        Bagage bagage = new Bagage(gewicht);
                        System.out.print("Geef de naam in van de passagier: ");
                        String name = scanner.next();
                        System.out.print("Geef de leeftijd in van de passagier: ");
                        int leeftijd = scanner.nextInt();
                        System.out.print("Geef het adres in van de passagier: ");
                        String adres = scanner.next();
                        Passagier passagier = new Passagier(name, leeftijd, adres, bagage);
                        passagiers.add(passagier);
                        break;
                    case "b":

                        break;
                    case "c":
                        break;
                    case "d":
                        break;
                    case "e":
                        break;
                    case "f":
                        exit = true;
                        break;
                    default:
                        System.out.println("de keuze bestaat niet gelieve een juist nummer in te voeren.");
                        keuze = scanner.nextLine();
                }
            }














    }
}