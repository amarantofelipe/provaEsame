# Documentazione della Classe `Service` 

La classe `Service` è un livello di servizio che funge da intermediario per l'interazione con la classe `Cinema`. Contiene i metodi principali per gestire operazioni relative ai film, agli orari e alle prenotazioni in un cinema.

---

## **Costruttore**
```java
public Service() {
    this.cinema = new Cinema();
}
```
- Il costruttore inizializza un'istanza della classe `Cinema`.
- Ogni oggetto della classe `Service` avrà il proprio oggetto `Cinema` per gestire i dati.

---

## **Metodi**

### **1. `aggiungiFilm(String nomeFilm, List<String> orari)`**
```java
public void aggiungiFilm(String nomeFilm, List<String> orari) {
    cinema.aggiungiFilm(nomeFilm, orari);
    System.out.println("Film aggiunto: " + nomeFilm + " con orari: " + orari);
}
```
- **Descrizione:** Aggiunge un nuovo film con i rispettivi orari di proiezione.
- **Funzionamento:**
  - Invoca il metodo `aggiungiFilm` dell'oggetto `Cinema` per memorizzare il nome del film e gli orari associati.
  - Dopo l'aggiunta, stampa un messaggio di conferma.
- **Esempio d'uso:** 
  ```java
  aggiungiFilm("Avatar", Arrays.asList("14:00", "16:30", "20:00"));
  ```

---

### **2. `aggiungiPrenotazione(String nome, boolean premium, String nomeFilm, String orario, int posti, double costoBiglietto)`**
```java
public void aggiungiPrenotazione(String nome, boolean premium, String nomeFilm, String orario, int posti, double costoBiglietto) {
    Cliente cliente = new Cliente(nome, premium);
    Prenotazione prenotazione = new Prenotazione(cliente, nomeFilm, orario, posti, costoBiglietto);

    if (!cinema.aggiungiPrenotazione(prenotazione)) {
        System.out.println("Errore: Non è stato possibile aggiungere la prenotazione per " + orario);
    }
}
```
- **Descrizione:** Aggiunge una nuova prenotazione per un determinato film e orario.
- **Funzionamento:**
  1. Crea un oggetto `Cliente` con il nome e l'indicatore di status premium.
  2. Crea una prenotazione usando i dati del cliente, il nome del film, l'orario, il numero di posti e il costo del biglietto.
     - Se il cliente è premium, ottiene uno sconto del 10% (calcolato automaticamente nella classe `Prenotazione`).
  3. Invia la prenotazione al metodo `aggiungiPrenotazione` della classe `Cinema`.
  4. Stampa un messaggio di errore nel caso in cui la prenotazione non venga aggiunta (ad esempio, per superamento della capienza massima).
- **Esempio d'uso:**
  ```java
  aggiungiPrenotazione("Mario Rossi", true, "Avatar", "20:00", 4, 10.0);
  ```

---

### **3. `stampaOrariFilm(String nomeFilm)`**
```java
public void stampaOrariFilm(String nomeFilm) {
    List<String> orari = cinema.getOrariFilm(nomeFilm);
    if (orari.isEmpty()) {
        System.out.println("Nessun orario trovato per il film: " + nomeFilm);
    } else {
        System.out.println("Orari di proiezione per '" + nomeFilm + "': " + orari);
    }
}
```
- **Descrizione:** Recupera e stampa tutti gli orari di proiezione disponibili per un film specifico.
- **Funzionamento:**
  1. Chiama il metodo `getOrariFilm` della classe `Cinema` per ottenere la lista degli orari associati al film.
  2. Se la lista degli orari è vuota, stampa un messaggio che indica la mancanza di orari.
  3. Altrimenti, stampa gli orari disponibili per il film.
- **Esempio d'uso:**
  ```java
  stampaOrariFilm("Avatar");
  ```

---

### **4. `stampaPostiERicavoTotale(String orario)`**
```java
public void stampaPostiERicavoTotale(String orario) {
    int postiPrenotati = cinema.getPostiPrenotati(orario);
    double ricavoTotale = cinema.getRicavoTotale(orario);
    System.out.println("Posti prenotati alle " + orario + ": " + postiPrenotati);
    System.out.println("Ricavo totale per l'orario " + orario + ": " + ricavoTotale);
}
```
- **Descrizione:** Stampa il numero totale di posti prenotati e i ricavi generati per uno specifico orario.
- **Funzionamento:**
  1. Chiama il metodo `getPostiPrenotati` della classe `Cinema` per calcolare il numero totale di posti prenotati per un orario specifico.
  2. Chiama il metodo `getRicavoTotale` della classe `Cinema` per calcolare il ricavo totale delle prenotazioni.
  3. Stampa i dati ottenuti.
- **Esempio d'uso:**
  ```java
  stampaPostiERicavoTotale("20:00");
  ```

---

## **Relazione con le altre Classi**
La classe `Service` interagisce con altre classi per implementare le sue funzionalità:

### **1. Classe `Cinema`**
- Responsabile della gestione di:
  - Film e relativi orari di proiezione.
  - Prenotazioni effettuate dai clienti.
- Contiene metodi come:
  - `aggiungiFilm`: Aggiunge film e relativi orari.
  - `aggiungiPrenotazione`: Gestisce l'aggiunta di prenotazioni, rispettando vincoli come la capienza massima.
  - `getOrariFilm`: Ritorna la lista degli orari per uno specifico film.
  - `getPostiPrenotati`: Calcola il totale dei posti prenotati.
  - `getRicavoTotale`: Calcola i ricavi totali delle prenotazioni.

---

### **2. Classe `Cliente`**
- Rappresenta un cliente del cinema.
- Ogni cliente ha:
  - **Nome:** Identificativo del cliente.
  - **Status Premium:** Determina se il cliente ha diritto a uno sconto del 10% sui biglietti.

---

### **3. Classe `Prenotazione`**
- Rappresenta una prenotazione per un film.
- Contiene informazioni come:
  - Cliente associato alla prenotazione.
  - Nome del film, orario, numero di posti prenotati.
  - Costo totale calcolato in base al numero di posti e al costo del biglietto (applicando lo sconto per clienti premium, se applicabile).

---

## **Funzionalità Principali**
1. **Aggiungere Film e Orari:** 
   - Consente di aggiungere nuovi film con gli orari associati.
2. **Gestione delle Prenotazioni:** 
   - Consente di registrare prenotazioni per specifici film ed orari, verificando la capienza massima.
3. **Visualizzazione Dati:**
   - Stampa:
     - Orari disponibili per un film.
     - Numero totale di posti prenotati e ricavi totali per uno specifico orario.

---

Se hai bisogno di ulteriori dettagli, non esitare a chiedere! 😊