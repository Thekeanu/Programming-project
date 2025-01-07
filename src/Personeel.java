public class Personeel extends Persoon{
    int id;
    String Job;

    public Personeel(String naam, int leeftijd, String adres, String job) {

        super(naam, leeftijd, adres);
        this.Job = job;
    }
}
