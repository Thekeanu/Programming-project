public class Vliegtuig {
    String vertrekpunt;
    String bestemming;
    boolean flightcheck = false;
    int business;
    int economy;
    Passagier[] passagier;
    Personeel[] Personeel;
    public Vliegtuig(String vertrekpunt, String bestemming, int business, int economy ) {
        this.vertrekpunt = vertrekpunt;
        this.bestemming = bestemming;
        this.business = business;
        this.economy = economy;
    }
}
