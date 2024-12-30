public class Prenotazione {
    private Cliente cliente;
    private String nomeFilm;
    private String orario;
    private int posti;
    private double costoBiglietto;

    public Prenotazione(Cliente cliente, String nomeFilm, String orario, int posti, double costoBiglietto) {
        this.cliente = cliente;
        this.nomeFilm = nomeFilm;
        this.orario = orario;
        this.posti = posti;
        this.costoBiglietto = cliente.isPremium() ? costoBiglietto * 0.9 : costoBiglietto; // Sconto del 10% per i premium
    }

    public int getPosti() {
        return posti;
    }

    public double getCostoTotale() {
        return posti * costoBiglietto;
    }

    public String getOrario() {
        return orario;
    }
}