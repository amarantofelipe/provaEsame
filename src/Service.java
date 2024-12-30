import java.util.*;

public class Service {
    private Cinema cinema;

    public Service() {
        this.cinema = new Cinema();
    }

    // Aggiunge un nuovo film con i suoi orari
    public void aggiungiFilm(String nomeFilm, List<String> orari) {
        cinema.aggiungiFilm(nomeFilm, orari);
        System.out.println("Film aggiunto: " + nomeFilm + " con orari: " + orari);
    }

    // Aggiunge una nuova prenotazione
    public void aggiungiPrenotazione(String nome, boolean premium, String nomeFilm, String orario, int posti, double costoBiglietto) {
        Cliente cliente = new Cliente(nome, premium); // Crea un nuovo cliente
        Prenotazione prenotazione = new Prenotazione(cliente, nomeFilm, orario, posti, costoBiglietto);

        // Aggiunge la prenotazione al cinema
        if (!cinema.aggiungiPrenotazione(prenotazione)) {
            System.out.println("Errore: Non è stato possibile aggiungere la prenotazione per " + orario);
        }
    }

    // Stampa gli orari di un film, dato il suo nome
    public void stampaOrariFilm(String nomeFilm) {
        List<String> orari = cinema.getOrariFilm(nomeFilm);
        if (orari.isEmpty()) {
            System.out.println("Nessun orario trovato per il film: " + nomeFilm);
        } else {
            System.out.println("Orari di proiezione per '" + nomeFilm + "': " + orari);
        }
    }

    // Stampa il numero di posti prenotati e il ricavo totale per un orario specifico
    public void stampaPostiERicavoTotale(String orario) {
        int postiPrenotati = cinema.getPostiPrenotati(orario);
        double ricavoTotale = cinema.getRicavoTotale(orario);
        System.out.println("Posti prenotati alle " + orario + ": " + postiPrenotati);
        System.out.println("Ricavo totale per l'orario " + orario + ": " + ricavoTotale);
    }
}