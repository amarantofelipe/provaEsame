import java.util.*;

/**
 * La classe Cinema rappresenta un sistema di gestione
 * di film, orari e prenotazioni per un cinema.
 * Permette di aggiungere film con relativi orari, effettuare prenotazioni
 * e calcolare statistiche come i posti prenotati e il ricavo totale.
 */
public class Cinema {
    private static final int CAPACITA_MAX = 75;
    private Map<String, List<String>> filmOrari = new HashMap<>();
    private Map<String, List<Prenotazione>> prenotazioniPerOrario = new HashMap<>();

    // Aggiunge un film con i suoi orari
    public void aggiungiFilm(String nomeFilm, List<String> orari) {
        filmOrari.put(nomeFilm, orari);
        for (String orario : orari) {
            prenotazioniPerOrario.put(orario, new ArrayList<>());
        }
    }

    // Ritorna gli orari di un film dato il nome
    public List<String> getOrariFilm(String nomeFilm) {
        return filmOrari.getOrDefault(nomeFilm, new ArrayList<>());
    }

    // Aggiunge una prenotazione
    public boolean aggiungiPrenotazione(Prenotazione prenotazione) {
        String orario = prenotazione.getOrario();
        List<Prenotazione> prenotazioni = prenotazioniPerOrario.get(orario);

        // Controlla se esiste un orario valido e la capienza massima
        if (prenotazioni != null && getPostiPrenotati(orario) + prenotazione.getPosti() <= CAPACITA_MAX) {
            prenotazioni.add(prenotazione);
            return true;
        }
        return false;
    }

    // Calcola i posti prenotati per un orario
    public int getPostiPrenotati(String orario) {
        return prenotazioniPerOrario.getOrDefault(orario, new ArrayList<>())
                .stream()
                .mapToInt(Prenotazione::getPosti)
                .sum();
    }

    // Calcola il ricavo totale per un orario
    public double getRicavoTotale(String orario) {
        return prenotazioniPerOrario.getOrDefault(orario, new ArrayList<>())
                .stream()
                .mapToDouble(Prenotazione::getCostoTotale)
                .sum();
    }
}