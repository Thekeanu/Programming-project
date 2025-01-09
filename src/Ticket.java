public class Ticket {
    Vliegtuig vliegtuig;
    String plaats;
    Passagier passagier;

    public Ticket(Vliegtuig vliegtuig, String plaats, Passagier passagier) {
        this.vliegtuig = vliegtuig;
        this.plaats = plaats;
        this.passagier = passagier;
    }
}
