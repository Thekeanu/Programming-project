import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Luchthaven {

    public static String vluchtLijst(ArrayList<Vliegtuig> vluchten, Scanner scanner){
        System.out.println("selecteer de juiste vlucht: ");
        int i = 1;
        for (Vliegtuig value : vluchten) {
            System.out.println( i +")" + value.vluchtcode + " " + value.bestemming + " " + value.vertrekpunt);
            i++;
        }

        return scanner.nextLine();
    }

    public static void main(String[] args) {

    ArrayList<Personeel> personeel = new ArrayList<Personeel>();
    ArrayList<Passagier> passagiers = new ArrayList<Passagier>();
    ArrayList<Vliegtuig> vluchten = new ArrayList<Vliegtuig>();
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while(!exit){

    System.out.println("a) nieuwe passagier \nb) nieuw ticket \nc) nieuwe vlucht \nd) voeg personeel toe aan vlucht \ne) boarding passagiers \nf) voeg personeel toe \ng) print vlucht info \nh) exit");
    System.out.println("Kies 1 van de bovenstaande opties");
    String keuze = scanner.nextLine();
                switch (keuze.toLowerCase().trim()){

                    case "a":
                        System.out.print("geef het gewicht van de bagage in KG: ");
                                String gewicht = scanner.nextLine();
                                try{
                                    int g = Integer.parseInt(gewicht.trim());

                                    if (g <= 20) {
                                        Bagage bagage = new Bagage(g);
                                        System.out.print("Geef de naam in van de passagier: ");
                                        String name = scanner.nextLine();
                                        name = name.toLowerCase().trim();
                                        System.out.print("Geef de leeftijd in van de passagier: ");
                                        String leeftijd = scanner.nextLine();
                                        int l = Integer.parseInt(leeftijd.trim());
                                        System.out.print("Geef het adres in van de passagier: ");
                                        String adres = scanner.nextLine();
                                        Passagier passagier = new Passagier(name, l, adres, bagage);
                                        passagiers.add(passagier);
                                        System.out.println("passagier aangemaakt");
                                    } else {
                                        System.out.println("het gewicht van de bagage mag maximum 20 KG wegen");
                                    }
                                }catch ( NumberFormatException e){
                                    System.out.println("U hebt geen nummer ingegeven probeer opnieuw");

                                }
                            break;
                            case "b":
                               String optie =  vluchtLijst(vluchten, scanner);

                                try {
                                    int optieInt = Integer.parseInt(optie);
                                    Vliegtuig vlucht = vluchten.get(optieInt - 1);
                                    System.out.println("1) Economy ticket");
                                    System.out.println("2) business ticket");
                                    String type = scanner.nextLine();
                                    while (!Objects.equals(type, "1") && !Objects.equals(type, "2") ) {
                                        System.out.println("geef een juist nummer in");
                                        type = scanner.nextLine();
                                    }
                                    if (type.equals("1")){
                                        if (vlucht.overigeEconomy == 0){
                                            System.out.println("er zijn geen plaats meer voor economy");
                                        }else{
                                            System.out.print("geef de naam in van de passagier: ");
                                            String naam = scanner.nextLine();
                                            for (Passagier passagier : passagiers){
                                                if (passagier.naam.equals(naam)){
                                                    String klasse = "economy";
                                                    Ticket ticket = new Ticket(vlucht, klasse, passagier);
                                                    passagier.setTicket(ticket);
                                                    System.out.println("Ticket voor " + passagier.naam + " "+ "aangemaakt");
                                                }
                                            }
                                        }
                                    }else if (type.equals("2")){

                                        if (vlucht.overigeBusiness == 0){
                                            System.out.println("er zijn geen plaats meer voor business");
                                        }else{
                                            System.out.print("geef de naam in van de passagier: ");
                                            String naam = scanner.nextLine();
                                            for (Passagier passagier : passagiers){
                                                if (passagier.naam.equals(naam.toLowerCase().trim())){
                                                    String klasse = "business";
                                                    Ticket ticket = new Ticket(vlucht, klasse, passagier);
                                                    passagier.setTicket(ticket);
                                                    System.out.println("Ticket voor " + passagier.naam + "aangemaakt");
                                                }
                                            }
                                        }
                                    }
                                }catch ( NumberFormatException e){
                                    System.out.println("U hebt geen nummer ingegeven probeer opnieuw");
                                }catch (IndexOutOfBoundsException e){
                                    System.out.println("de vlucht die u probeerde selecteren werkte niet");
                                }
                                break;
                            case "c":
                                System.out.print("Geef de vluchtcode in: ");
                                String vluchtcode = scanner.nextLine();
                                System.out.print("Geef het vertrekpunt in van de vlucht: ");
                                String vertrekpunt = scanner.nextLine();
                                System.out.print("Geef de bestemming in van de vlucht: ");
                                String bestemming = scanner.nextLine();
                                if (!bestemming.equals(vertrekpunt.toLowerCase().trim())){
                                    try{
                                        System.out.print("Geef het aantal business plaatsen in: ");
                                        String business = scanner.nextLine();
                                        int businessInt = Integer.parseInt(business);
                                        System.out.print("Geef het aantal economy plaatsen in: ");
                                        String economy = scanner.nextLine();
                                        int economyInt = Integer.parseInt(economy);
                                        Vliegtuig vliegtuig = new Vliegtuig(vluchtcode, vertrekpunt, bestemming, businessInt, economyInt);
                                        vluchten.add(vliegtuig);
                                        System.out.println("De vlucht met vluchtcode " + vluchtcode + " is toegevoegd aan de vluchten");
                                    }catch ( NumberFormatException e){
                                        System.out.println("U hebt geen nummer ingegeven probeer opnieuw");
                                    }
                                }else{
                                    System.out.println("een vliegtuig kan niet hetzelfde vertrekpunt als bestemming hebben");
                                }

                                break;
                            case "d":
                                if (personeel.isEmpty()){
                                    System.out.print("er zijn geen personeels leden in het systeem");
                                }else {
                                    String id = vluchtLijst(vluchten, scanner);
                                    try{
                                        int idInt = Integer.parseInt(id);
                                        Vliegtuig vlucht = vluchten.get(idInt - 1);
                                        System.out.print("Geef de naam in van het personeelslid: ");
                                        String naam = scanner.nextLine();
                                        for (Personeel p : personeel){
                                            if (p.naam.equals(naam.toLowerCase().trim())){
                                                vlucht.addPersoneel(p);
                                            }else{
                                                System.out.print("geen personeelslid gevonden met deze naam");
                                            }
                                        }
                                    }catch ( NumberFormatException e){
                                        System.out.println("u heeft geen geldig nummer gekozen.");
                                    }

                                }
                                break;
                            case "e":
                                if (passagiers.isEmpty()){
                                    System.out.println("er zeen geen passagiers in het systeem");
                                }else{
                                    System.out.print("geef de naam in van de passagier: ");
                                    String naam = scanner.nextLine();
                                    for (Passagier passagier : passagiers){
                                        if (naam.equals(passagier.naam.toLowerCase().trim())){
                                            String id = vluchtLijst(vluchten, scanner);
                                            try {
                                                int idInt = Integer.parseInt(id);
                                                Vliegtuig vlucht = vluchten.get(idInt - 1);
                                                vlucht.addPassagier(passagier);
                                            }catch ( NumberFormatException e){
                                                System.out.println("U hebt geen geldig nummer ingegeven ");
                                            }

                                        }else {
                                            System.out.println("er is geen passagier met deze naam in het systeem");
                                        }
                                    }
                                }
                                break;
                            case "f":
                                System.out.print("Geef de naam in van het personeelslid: ");
                                String name = scanner.nextLine();
                                name = name.toLowerCase().trim();
                                System.out.print("Geef de leeftijd in van het personeelslid: ");
                                String leeftijd = scanner.nextLine();
                                try {
                                    int l = Integer.parseInt(leeftijd.trim());
                                    System.out.print("Geef het adres in van het personeelslid: ");
                                    String adres = scanner.nextLine();
                                    System.out.print("job");
                                    String job = scanner.nextLine();
                                    Personeel p = new Personeel(name, l, adres, job);
                                    personeel.add(p);
                                }catch (NumberFormatException e){
                                    System.out.println("U hebt geen nummer ingegeven ");
                                }

                                break;
                            case "g":
                                if (vluchten.isEmpty()){
                                    System.out.println("er zeen geen vluchten in het systeem");

                                }else{
                                    String v = vluchtLijst(vluchten, scanner);
                                    try{
                                        int idInt = Integer.parseInt(v);
                                        Vliegtuig vlucht = vluchten.get(idInt - 1);
                                        String input = vlucht.toString();

                                        try(ObjectOutputStream output = new ObjectOutputStream(
                                                new FileOutputStream(vlucht.vluchtcode+".txt")
                                        )){
                                            output.writeObject(input);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }catch (NumberFormatException e){
                                        System.out.println("U hebt geen nummer ingegeven probeer");
                                    }

                                }
                                break;
                            case "h":
                                exit = true;
                                break;
                            default:
                                System.out.println("de keuze bestaat niet gelieve een juiste letter in te voeren.");




            }
    }
}}