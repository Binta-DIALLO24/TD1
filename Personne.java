import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personne {
    private String nom;
    private String prenom;
    private String matricule;
    private int age;
    private LocalDate dateNaissance;

    private static int id = 1;

    public Personne() {
    }

    public Personne(String nom, String prenom, int age, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateNaissance = dateNaissance;
        this.matricule = genererMatricule();
    }

    private String genererMatricule() {
        String matricule = prenom.substring(0, 1).toUpperCase() +
                nom.substring(0, 1).toUpperCase() +
                String.format("%04d", id++);
        return matricule;
    }

    public int calculerAge() {
        LocalDate dateActuelle = LocalDate.now();
        return dateActuelle.getYear() - dateNaissance.getYear();
    }

    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.matricule = genererMatricule();
        this.age = calculerAge();
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", age=" + age +
                ", dateNaissance=" + dateNaissance.format(dateFormat) +
                '}';
    }
}


