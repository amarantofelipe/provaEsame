# Spiegazione della Classe `Cinema` in Java

La classe `Cinema` rappresenta un sistema per la gestione di un cinema. Offre funzionalità per aggiungere film, gestire orari, creare prenotazioni e calcolare statistiche. Di seguito la spiegazione del codice.

---

## **Costanti e Attributi Principali**

### 1. **Costante `CAPACITA_MAX`**
```java
private static final int CAPACITA_MAX = 75;
```
- Definisce la capacità massima della sala: **75 posti** per ciascun orario.

---

### 2. **Mappa `filmOrari`**
```java
private Map<String, List<String>> filmOrari = new HashMap<>();
```
- Contiene i film e i loro orari.
    - **Chiave (`String`)**: Nome del film.
    - **Valore**: Lista di orari relativi al film.

---

### 3. **Mappa `prenotazioniPerOrario`**
```java
private Map<String, List<Prenotazione>> prenotazioniPerOrario = new HashMap<>();
```
- Contiene le prenotazioni organizzate per ogni orario.
    - **Chiave (`String`)**: Orario.
    - **Valore**: Lista di oggetti `Prenotazione`.

---

## **Metodi Principali**

### 1. **Aggiunta di un Film con Orari**
```java
public void aggiungiFilm(String nomeFilm, List<String> orari) {
    filmOrari.put(nomeFilm, orari);
    for (String orario : orari) {
        prenotazioniPerOrario.put(orario, new ArrayList<>());
    }
}
```
- Permette di aggiungere un nuovo film e i relativi orari.
    - Popola la mappa `filmOrari` con il film e i suoi orari.
    - Per ogni nuovo orario, aggiunge una lista vuota di prenotazioni nella mappa `prenotazioniPerOrario`.

---

### 2. **Ottenere Orari di un Film**
```java
public List<String> getOrariFilm(String nomeFilm) {
    return filmOrari.getOrDefault(nomeFilm, new ArrayList<>());
}
```
- Restituisce la lista degli orari di un determinato film.
- Se il film non esiste, restituisce una lista vuota.

---

### 3. **Aggiungere una Prenotazione**
```java
public boolean aggiungiPrenotazione(Prenotazione prenotazione) {
    String orario = prenotazione.getOrario();
    List<Prenotazione> prenotazioni = prenotazioniPerOrario.get(orario);

    // Controlla validità e capienza massima
    if (prenotazioni != null && getPostiPrenotati(orario) + prenotazione.getPosti() <= CAPACITA_MAX) {
        prenotazioni.add(prenotazione);
        return true;
    }
    return false;
}
```
- Permette di aggiungere una nuova prenotazione controllando:
    1. **Validità dell'orario**.
    2. **Capacità massima**: verifica che i posti richiesti non superino i posti disponibili.
- Se le condizioni sono soddisfatte:
    - La prenotazione viene aggiunta alla lista.
    - Viene restituito `true`.
- Altrimenti, restituisce `false`.

---

### 4. **Calcolo dei Posti Prenotati per un Orario**
```java
public int getPostiPrenotati(String orario) {
    return prenotazioniPerOrario.getOrDefault(orario, new ArrayList<>())
            .stream()
            .mapToInt(Prenotazione::getPosti)
            .sum();
}
```
- Calcola il numero totale di posti prenotati per un determinato orario:
    - Recupera la lista di prenotazioni per quell'orario.
    - Somma il valore dei posti richiesti in ciascuna prenotazione usando il metodo `getPosti()`.

---

### 5. **Calcolo del Ricavo Totale per un Orario**
```java
public double getRicavoTotale(String orario) {
    return prenotazioniPerOrario.getOrDefault(orario, new ArrayList<>())
            .stream()
            .mapToDouble(Prenotazione::getCostoTotale)
            .sum();
}
```
- Calcola il guadagno totale generato dalle prenotazioni per un orario specifico:
    - Recupera la lista di prenotazioni relative a quell'orario.
    - Somma i costi di ciascuna prenotazione utilizzando il metodo `getCostoTotale()` della classe `Prenotazione`.

---

## **Integrazione con la Classe `Prenotazione`**

### **Descrizione**
La classe `Prenotazione` rappresenta i dettagli delle prenotazioni. Ogni prenotazione è associata a un cliente, un film, un orario, il numero di posti prenotati e il costo del biglietto.

---

### **Dettagli del Costruttore**
```java
public Prenotazione(Cliente cliente, String nomeFilm, String orario, int posti, double costoBiglietto) {
    this.cliente = cliente;
    this.nomeFilm = nomeFilm;
    this.orario = orario;
    this.posti = posti;
    this.costoBiglietto = cliente.isPremium() ? costoBiglietto * 0.9 : costoBiglietto;
}
```
- Se il cliente ha l'opzione **`Premium`**, ottiene uno **sconto del 10%** sul costo del biglietto.

---

### **Metodi Principali della Classe Prenotazione**
1. **Calcolo del Costo Totale**
   ```java
   public double getCostoTotale() {
       return posti * costoBiglietto;
   }
   ```
    - Restituisce il costo totale della prenotazione, moltiplicando il numero di posti per il costo del biglietto.

2. **Numero di Posti Prenotati**
   ```java
   public int getPosti() {
       return posti;
   }
   ```
    - Restituisce il numero di posti inclusi nella prenotazione.

3. **Orario della Prenotazione**
   ```java
   public String getOrario() {
       return orario;
   }
   ```
    - Restituisce l'orario relativo alla prenotazione.

---

## **Conclusione**

### **Responsabilità Chiare**
- **Classe `Cinema`**: Gestisce film, orari e prenotazioni.
- **Classe `Prenotazione`**: Gestisce i dettagli di singole prenotazioni.

### **Miglioramenti Possibili**
- Aggiungere nuove funzionalità, come:
    - Gestione avanzata delle eccezioni.
    - Miglioramento dell'interazione utente.
    - Un'interfaccia grafica per la gestione del cinema.

Questa implementazione, grazie alla modularità e all'uso di strutture dati come `Map`, è efficace, intuitiva e facilmente scalabile.