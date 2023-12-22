import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom : ");
        String nom = scanner.nextLine();

        System.out.print("Entrez le prénom : ");
        String prenom = scanner.nextLine();

        System.out.print("Entrez la date de naissance (format dd/MM/yyyy) : ");
        String dateNaissanceStr = scanner.next();

        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateNaissance = LocalDate.parse(dateNaissanceStr, dateFormat);

            Personne personne = new Personne(nom, prenom, dateNaissance);
            System.out.println(personne);
        } catch (Exception e) {
            System.out.println("La date de naissance doit être au format dd/MM/yyyy");
        } finally {
            scanner.close();
        }
    }
}
