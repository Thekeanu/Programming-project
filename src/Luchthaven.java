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
    System.out.println("Kies 1 van de bovenstaande opties");
    String keuze = scanner.nextLine();
                switch (keuze){

                    case "a":
                        System.out.print("geef het gewicht van de bagage in KG: ");
                                String gewicht = scanner.nextLine();
                                try{
                                    int g = Integer.parseInt(gewicht);

                                    if (g <= 20) {
                                        Bagage bagage = new Bagage(g);
                                        System.out.print("Geef de naam in van de passagier: ");
                                        String name = scanner.nextLine();
                                        System.out.print("Geef de leeftijd in van de passagier: ");
                                        String leeftijd = scanner.nextLine();
                                        int l = Integer.parseInt(leeftijd);
                                        System.out.print("Geef het adres in van de passagier: ");
                                        String adres = scanner.nextLine();
                                        Passagier passagier = new Passagier(name, l, adres, bagage);
                                        passagiers.add(passagier);
                                    } else {
                                        System.out.println("het gewicht van de bagage mag maximum 20 KG wegen");
                                    }
                                }catch ( NumberFormatException e){
                                    System.out.println("U hebt geen nummer ingegeven probeer opnieuw");

                                }
                            break;
                            case "b":

                                break;
                            case "c":
                                System.out.println("Geef de vluchtcode in: ");
                                String vluchtcode = scanner.nextLine();
                                System.out.print("Geef het vertrekpunt in van de vlucht: ");
                                String vertrekpunt = scanner.nextLine();
                                System.out.println("Geef de bestemming in van de vlucht: ");
                                String bestemming = scanner.nextLine();
                                try{

                                    System.out.println("Geef het aantal business plaatsen in: ");
                                    String business = scanner.nextLine();
                                    int businessInt = Integer.parseInt(business);
                                    System.out.println("Geef het aantal economy plaatsen in: ");
                                    String economy = scanner.nextLine();
                                    int economyInt = Integer.parseInt(economy);

                                    Vliegtuig vliegtuig = new Vliegtuig(vluchtcode, vertrekpunt, bestemming, businessInt, economyInt);
                                    vluchten.add(vliegtuig);
                                    System.out.println("De vlucht met vluchtcode " + vluchtcode + " is toegevoegd aan de vluchten");
                                }catch ( NumberFormatException e){
                                    System.out.println("U hebt geen nummer ingegeven probeer opnieuw");
                                }
                                break;
                            case "d":
                                break;
                            case "e":
                                break;
                            case "f":
                                exit = true;
                                break;
                            default:
                                System.out.println("de keuze bestaat niet gelieve een juiste letter in te voeren.");



            }
    }
}}