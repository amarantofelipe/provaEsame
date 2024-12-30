# Sistema di Prenotazione del Cinema - Struttura del Progetto

Il progetto rappresenta un **sistema di prenotazione per un cinema**, strutturato in diverse classi che collaborano tra loro per fornire le funzionalità principali. Ogni classe ha un ruolo ben definito e contribuisce al funzionamento complessivo del sistema.

---

## **Struttura Generale del Progetto**

Il progetto è composto dalle seguenti classi principali:

1. **`Main`**: La classe principale, che gestisce l'interazione con l'utente e il flusso dell'applicazione.
2. **`Service`**: Una classe di supporto che agisce come intermediario fra la classe `Main` e le funzionalità interne di gestione, implementate nella classe `Cinema`.
3. **`Cinema`**: Il cuore del sistema, che gestisce i dati relativi ai film, proiezioni e prenotazioni.
4. **`Cliente`**: Una classe che rappresenta i clienti, con uno speciale flag che indica se sono premium.
5. **`Prenotazione`**: Una classe che rappresenta una prenotazione specifica, contenente i dettagli di un cliente, un film e i relativi posti prenotati.

---

## **Classi e Ruoli**

### **1. Classe `Main`**
La classe principale (`Main`) funge da punto di ingresso per il programma. È responsabile di:
- Mostrare il menù interattivo all'utente.
- Raccogliere dati e input da console.
- Delegare le operazioni alla classe `Service`.

**Flusso della classe `Main`:**
- L'utente interagisce con il menù all'interno di un ciclo `while`.
- Un blocco `switch` gestisce le diverse scelte dell'utente:
  - **Caso 1:** Aggiungere un film e i relativi orari.
  - **Caso 2:** Aggiungere una prenotazione.
  - **Caso 3:** Consultare gli orari di proiezione di un film.
  - **Caso 4:** Verificare i posti prenotati e il ricavo totale per un determinato orario.
  - **Caso 5:** Uscire dal programma.

La classe `Main` si occupa solo della raccolta dei dati e delega tutta la logica al **service**.

---

### **2. Classe `Service`**
La classe `Service` è il punto di interfaccia tra `Main` e la logica principale contenuta nella classe `Cinema`. Organizza i dati raccolti dalla classe `Main` e si occupa di inviarli alla classe `Cinema` per l'elaborazione.

**Metodi principali di `Service`:**
1. **`aggiungiFilm(String nomeFilm, List<String> orari)`**  
   - Aggiunge un nuovo film con i relativi orari gestiti dal sistema.
   
2. **`aggiungiPrenotazione(String nome, boolean premium, String nomeFilm, String orario, int posti, double costoBiglietto)`**  
   - Crea un oggetto `Cliente` e un oggetto `Prenotazione`.
   - Passa la prenotazione all'oggetto `Cinema`.

3. **`stampaOrariFilm(String nomeFilm)`**  
   - Recupera e stampa gli orari di proiezione per un film specifico dal sistema `Cinema`.

4. **`stampaPostiERicavoTotale(String orario)`**  
   - Richiede e stampa informazioni sui posti prenotati e il ricavo totale per uno specifico orario.

**Connessioni con altre classi:**
La classe `Service` interagisce direttamente con un'istanza della classe `Cinema`:
```java
private Cinema cinema;
```

---

### **3. Classe `Cinema`**
La classe `Cinema` è il nucleo centrale del sistema. Contiene i dati e la logica per:
- Gestire una lista di **film**, ciascuno associato ai relativi orari disponibili.
- Registrare e organizzare **prenotazioni** effettuate dagli utenti.
- Calcolare **ricavi** e verificare la disponibilità di posti per ogni proiezione.

**Ruoli chiave della classe `Cinema`:**
1. **Gestione di film e orari:**  
   Mantiene la relazione tra titoli di film e i loro rispettivi orari (es. tramite una mappa o una struttura dati simile).

2. **Gestione delle prenotazioni:**  
   Registra e verifica le nuove prenotazioni su base orario e film:
   - Verifica che l'orario esista.
   - Calcola e registra i posti occupati per evitare conflitti.

3. **Gestione di ricavi e disponibilità:**  
   Tiene traccia dei posti prenotati e calcola i ricavi totali utilizzando i prezzi dei biglietti.

**Metodi principali di `Cinema`:**
1. **`aggiungiFilm(String nomeFilm, List<String> orari)`**  
   Aggiunge un nuovo film con gli orari associati.

2. **`aggiungiPrenotazione(Prenotazione prenotazione)`**  
   Registra una nuova prenotazione:
   - Verifica che vi sia disponibilità di posti nell'orario richiesto.
   - Aggiorna i dati relativi ai posti prenotati e ai ricavi.

3. **`getOrariFilm(String nomeFilm)`**  
   Restituisce gli orari di proiezione di un determinato film.

4. **`getPostiPrenotati(String orario)`**  
   Restituisce il numero totale di posti prenotati per un determinato orario.

5. **`getRicavoTotale(String orario)`**  
   Restituisce i ricavi totali relativi a un determinato orario.

---

### **4. Classe `Cliente`**
La classe `Cliente` rappresenta una persona che effettua una prenotazione.

**Attributi principali:**
- `String nome`: Il nome del cliente.
- `boolean isPremium`: Indica se il cliente è premium.

**Ruolo nella logica:**
- Se il cliente è **premium**, può ricevere sconti o vantaggi speciali.

---

### **5. Classe `Prenotazione`**
La classe `Prenotazione` raccoglie i dettagli di una prenotazione.

**Attributi principali:**
- **`Cliente cliente`**: Il cliente che effettua la prenotazione.
- **`String nomeFilm`**: Il film scelto.
- **`String orario`**: L'orario della proiezione.
- **`int posti`**: Numero di posti prenotati.
- **`double costoBiglietto`**: Prezzo base del biglietto (eventualmente personalizzato per i clienti premium).

---

## **Collegamenti tra le Classi**

1. La classe **`Main`** raccoglie l'input dall'utente e lo inoltra alla classe **`Service`**.
2. La classe **`Service`** richiama i metodi della classe **`Cinema`** per:
   - Registrare nuovi film.
   - Registrare nuove prenotazioni.
   - Recuperare orari, posti prenotati e ricavi.
3. La classe **`Cinema`** interagisce con oggetti ausiliari come **`Cliente`** e **`Prenotazione`**, memorizzandoli e gestendoli secondo la logica del sistema.

---

## **Flusso di Esecuzione del Sistema**

### **Esempio di utilizzo collaborativo:**
1. L'utente aggiunge un film.
   - `Main` → `Service` → `Cinema`.
2. L'utente effettua una prenotazione.
   - `Main` → `Service` → `Cinema` (con `Cliente` e `Prenotazione` come oggetti ausiliari).
3. L'utente consulta orari di un film, posti prenotati o ricavi totali.
   - `Main` → `Service` → `Cinema`.

---

## **Diagramma dei Collegamenti**

```plaintext
Main
 |--> Service
       |--> Cinema
             |--> Cliente
             |--> Prenotazione
```

---

## **Conclusione**

Il progetto segue il **principio di separazione delle responsabilità**, mantenendo le classi ben isolate e con scopi chiari:
- `Main`: Interfaccia con l'utente.
- `Service`: Ponte tra interfaccia e logica di business.
- `Cinema`: Gestione dei dati e applicazione della logica.
- `Cliente` e `Prenotazione`: Rappresentazione dei dati correlati.

Questa struttura rende il codice facile da mantenere, espandibile e adatto ad aggiungere nuove funzionalità in futuro, come gestione di più sale, offerte speciali o prenotazioni dinamiche.
