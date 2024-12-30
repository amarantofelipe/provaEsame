import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
        boolean continua = true;

        System.out.println("Benvenuto nel sistema di prenotazione del Cinema!");

        while (continua) {
            System.out.println("\nScegli un'operazione:");
            System.out.println("1. Aggiungi un film con orari");
            System.out.println("2. Aggiungi una prenotazione");
            System.out.println("3. Stampa orari di proiezione dato il nome del film");
            System.out.println("4. Stampa posti prenotati e ricavo totale per un orario");
            System.out.println("5. Esci");

            System.out.print("La tua scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    // Aggiungi un film con orari
                    System.out.print("Inserisci il nome del film: ");
                    String nomeFilm = scanner.nextLine();

                    System.out.print("Inserisci gli orari (separati da virgola, ad es. 18:00,21:00): ");
                    String orariInput = scanner.nextLine();
                    List<String> orari = Arrays.asList(orariInput.split(","));

                    service.aggiungiFilm(nomeFilm, orari);
                    break;

                case 2:
                    // Aggiungi una prenotazione
                    System.out.print("Inserisci il nome del cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Il cliente è premium? (true/false): ");
                    boolean isPremium = scanner.nextBoolean();

                    scanner.nextLine(); // Consuma il newline
                    System.out.print("Inserisci il nome del film desiderato: ");
                    String filmPrenotazione = scanner.nextLine();

                    System.out.print("Inserisci l'orario della proiezione: ");
                    String orarioPrenotazione = scanner.nextLine();

                    System.out.print("Inserisci il numero di posti da prenotare: ");
                    int posti = scanner.nextInt();

                    System.out.print("Inserisci il costo base del singolo biglietto: ");
                    double costoBiglietto = scanner.nextDouble();

                    scanner.nextLine(); // Consuma il newline
                    service.aggiungiPrenotazione(nomeCliente, isPremium, filmPrenotazione, orarioPrenotazione, posti, costoBiglietto);
                    break;

                case 3:
                    // Stampa gli orari di un film
                    System.out.print("Inserisci il nome del film per vedere gli orari: ");
                    String filmDaCercare = scanner.nextLine();

                    service.stampaOrariFilm(filmDaCercare);
                    break;

                case 4:
                    // Stampa numero di posti prenotati e ricavo totale
                    System.out.print("Inserisci l'orario della proiezione: ");
                    String orarioRicerca = scanner.nextLine();

                    service.stampaPostiERicavoTotale(orarioRicerca);
                    break;

                case 5:
                    // Esci
                    continua = false;
                    System.out.println("Grazie per aver utilizzato il sistema di prenotazione del Cinema!");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        scanner.close();
    }
}