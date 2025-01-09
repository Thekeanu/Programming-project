public class Passagier extends Persoon {
    Bagage bagage;
    Ticket ticket;

    public Passagier(String naam, int leeftijd, String adres, Bagage bagage) {
        super(naam, leeftijd, adres);
        this.bagage = bagage;
    }

    public Bagage getBagage() {
        return bagage;
    }

    public void setBagage(Bagage bagage) {
        this.bagage = bagage;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Passagier{" +
                "bagage=" + bagage +
                ", ticket=" + ticket +
                ", naam='" + naam + '\'' +
                ", leeftijd=" + leeftijd +
                ", adres='" + adres + '\'' +
                '}';
    }
}
