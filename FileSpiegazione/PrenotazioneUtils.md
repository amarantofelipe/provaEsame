# Classe `Prenotazione` in Java

La classe `Prenotazione` rappresenta una prenotazione legata a un cliente per un determinato film, orario e numero di posti. Inoltre, la classe offre funzionalità per calcolare il costo totale della prenotazione con un eventuale sconto per i clienti Premium.

---

## **Attributi Principali**

```java
private Cliente cliente;
private String nomeFilm;
private String orario;
private int posti;
private double costoBiglietto;
```

### Descrizione:
1. **`cliente`**: Rappresenta il cliente che effettua la prenotazione. È un'istanza della classe `Cliente`, che definisce il nome del cliente e il suo stato Premium.
2. **`nomeFilm`**: Il titolo del film per il quale è stata effettuata la prenotazione.
3. **`orario`**: Orario dello spettacolo.
4. **`posti`**: Numero di posti prenotati.
5. **`costoBiglietto`**: Il prezzo di un singolo biglietto. Questo valore viene modificato automaticamente se il cliente è Premium.

---

## **Costruttore**

```java
public Prenotazione(Cliente cliente, String nomeFilm, String orario, int posti, double costoBiglietto) {
    this.cliente = cliente;
    this.nomeFilm = nomeFilm;
    this.orario = orario;
    this.posti = posti;
    this.costoBiglietto = cliente.isPremium() ? costoBiglietto * 0.9 : costoBiglietto; // Sconto del 10% per i premium
}
```

### Funzionamento:
- Il costruttore inizializza i dettagli associati ad una prenotazione.
- Verifica se il cliente è Premium attraverso il metodo `isPremium()`:
  - Se **Premium**, il costo del biglietto viene ridotto del **10%** (`costoBiglietto * 0.9`).
  - In caso contrario, il costo rimane invariato.

---

## **Metodi**

### **1. Metodo `getPosti`**
```java
public int getPosti() {
    return posti;
}
```
- **Scopo**: Restituisce il numero di posti prenotati.
- **Valore ritornato**: Un intero rappresentante il numero di posti.

---

### **2. Metodo `getCostoTotale`**
```java
public double getCostoTotale() {
    return posti * costoBiglietto;
}
```
- **Scopo**: Calcola il costo totale della prenotazione.
- **Calcolo**: Moltiplica il numero di posti (`posti`) per il costo del singolo biglietto (`costoBiglietto`). Questo tiene conto dell'eventuale sconto applicato (Premium).

---

### **3. Metodo `getOrario`**
```java
public String getOrario() {
    return orario;
}
```
- **Scopo**: Restituisce l'orario dello spettacolo prenotato.
- **Valore ritornato**: Una stringa rappresentante l'orario.

---

## **Esempio di Utilizzo**

Ecco come potrebbero essere utilizzate le classi `Cliente` e `Prenotazione` insieme:

```java
public class Main {
    public static void main(String[] args) {
        // Creazione di clienti
        Cliente cliente1 = new Cliente("Mario Rossi", true); // Cliente Premium
        Cliente cliente2 = new Cliente("Luca Bianchi", false); // Cliente non Premium

        // Creazione di prenotazioni
        Prenotazione prenotazione1 = new Prenotazione(cliente1, "Film A", "18:00", 3, 10.0);
        Prenotazione prenotazione2 = new Prenotazione(cliente2, "Film B", "20:00", 2, 10.0);

        // Output del costo totale
        System.out.println("Costo totale prenotazione 1: " + prenotazione1.getCostoTotale());
        System.out.println("Costo totale prenotazione 2: " + prenotazione2.getCostoTotale());
    }
}
```

### **Output:**

---

## **Punti Chiave**

1. **Modularità**: La classe `Prenotazione` è strettamente legata alla classe `Cliente`, consentendo di rappresentare in modo chiaro i dettagli di un cliente e offrendo sconti Premium.

2. **Flessibilità**: Il costo del biglietto viene calcolato automaticamente tenendo conto dello stato del cliente.

3. **Semplicità**: L'uso di metodi come `getCostoTotale` e `getPosti` permette di accedere rapidamente ai dettagli principali relativi a una prenotazione.

---

## **Possibili Estensioni**
1. Aggiungere una validazione nel costruttore per impedire prenotazioni con un numero di posti negativi o zero.
2. Definire un metodo per cambiare il numero di posti dopo la creazione della prenotazione.
3. Includere funzionalità per cancellare o modificare una prenotazione.

Questa implementazione è semplice, efficace ed espandibile, ideale per integrarsi in sistemi più estesi (come la gestione di un cinema).