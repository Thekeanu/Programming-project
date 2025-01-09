import java.util.ArrayList;
import java.util.Objects;

public class Vliegtuig {
    String vluchtcode;
    String vertrekpunt;
    String bestemming;
    boolean flightcheck = false;
    int business;
    int overigeBusiness;
    int economy;
    int overigeEconomy;
    ArrayList<Passagier> passagiers = new ArrayList<Passagier>();
    ArrayList<Personeel> personeel = new ArrayList<Personeel>();

    public Vliegtuig(String vluchtcode,String vertrekpunt, String bestemming, int business, int economy ) {
        this.vertrekpunt = vertrekpunt;
        this.bestemming = bestemming;
        this.business = business;
        this.overigeEconomy = economy;
        this.overigeBusiness = business;
        this.economy = economy;
        this.vluchtcode = vluchtcode;
    }

    public void addPassagier(Passagier passagier) {
        if (Objects.equals(passagier.ticket.klasse, "economy")){
            if (Objects.equals(passagier.ticket.vliegtuig.vluchtcode, this.vluchtcode)){
                passagiers.add(passagier);

                System.out.println("De passagier mag boarden in " + passagier.ticket.klasse + " klasse.");
                overigeEconomy--;
            }else {
                System.out.println("De passagier probeert de verkeerde vlucht te boarden.");
            }
        } else if (Objects.equals(passagier.ticket.klasse, "business")){
            if (Objects.equals(passagier.ticket.vliegtuig.vluchtcode, this.vluchtcode)){
                passagiers.add(passagier);
                System.out.println("De passagier mag boarden in " + passagier.ticket.klasse + " klasse.");
                overigeBusiness--;
            }else {
                System.out.println("De passagier probeert de verkeerde vlucht te boarden.");
            }
        }
    }


    public void addPersoneel(Personeel persoon) {
        personeel.add(persoon);
    }

    public void setFlightcheck() {
        if (isPiloot()) {
            if (personeel.size() <= 8) {
                System.out.println("klaar om op te stijgen");
                this.flightcheck = true;
            }
        }
    }

    public boolean isPiloot() {
        for (Personeel value : personeel) {
            if (Objects.equals(value.Job, "piloot") || Objects.equals(value.Job, "Piloot")) {
                return true;
            }
        }
       return false;
    }

    @Override
    public String toString() {
        return " Vliegtuig{" +
                "vluchtcode='" + vluchtcode + '\'' +
                ", vertrekpunt='" + vertrekpunt + '\'' +
                ", bestemming='" + bestemming + '\'' +
                ", flightcheck=" + flightcheck +
                ", business=" + business +
                ", economy=" + economy +
                ", passagiers=" + passagiers +
                ", personeel=" + personeel +
                '}';
    }
}
