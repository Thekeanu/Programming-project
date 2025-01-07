public class Persoon {
    String naam;
    int leeftijd;
    String adres;

    public Persoon(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return
                "naam='" + naam + '\'' +
                ", leeftijd=" + leeftijd +
                ", adres='" + adres + '\'';
    }
}
