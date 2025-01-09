import java.util.Objects;

public class Vliegtuig {
    String vertrekpunt;
    String bestemming;
    boolean flightcheck = false;
    int business;
    int economy;
    Passagier[] passagiers;
    Personeel[] personeel;
    public Vliegtuig(String vertrekpunt, String bestemming, int business, int economy ) {
        this.vertrekpunt = vertrekpunt;
        this.bestemming = bestemming;
        this.business = business;
        this.economy = economy;
    }

    public void setFlightcheck(boolean flightcheck) {

        if (isPiloot()) {
            this.flightcheck = flightcheck;
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
}
