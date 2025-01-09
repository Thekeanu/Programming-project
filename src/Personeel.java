public class Personeel extends Persoon{

    String Job;

    public Personeel(String naam, int leeftijd, String adres, String job) {

        super(naam, leeftijd, adres);
        this.Job = job;
    }

    @Override
    public String toString() {
        return "Personeel{" +
                "Job='" + Job + '\'' +
                ", naam='" + naam + '\'' +
                ", leeftijd=" + leeftijd +
                ", adres='" + adres + '\'' +
                '}';
    }
}
