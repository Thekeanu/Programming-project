public class Ticket {
    Vliegtuig vliegtuig;
    String klasse;
    Passagier passagier;

    public Ticket(Vliegtuig vliegtuig, String klasse, Passagier passagier) {
        this.vliegtuig = vliegtuig;
        this.klasse = klasse;
        this.passagier = passagier;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "vliegtuig=" + vliegtuig +
                ", klasse='" + klasse + '\'' +
                ", passagier=" + passagier +
                '}';
    }
}
