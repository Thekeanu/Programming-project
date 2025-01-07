public class Passagier extends Persoon {
    Bagage bagage;
    Ticket ticket;

    public Passagier(String naam, int leeftijd, String adres, Bagage bagage) {
        super(naam, leeftijd, adres);
        this.bagage = bagage;
    }
}
