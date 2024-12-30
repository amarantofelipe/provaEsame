# Sistema di Prenotazione del Cinema - Descrizione del Codice

Questo progetto in **Java** rappresenta un sistema di prenotazione per un cinema, che consente agli utenti di gestire film, prenotazioni e calcolare informazioni come ricavi e posti occupati. Il programma utilizza una struttura ben organizzata, con una classe principale che gestisce l'interazione utente (`Main`) e una classe di servizio (`Service`) che interagisce con la logica della gestione dei dati, incapsulata in un oggetto `Cinema`.

---

## Struttura del Programma

### Classe `Main`

La classe `Main` contiene il **metodo `main`**, che rappresenta il punto d'ingresso del programma e gestisce l'interazione dell'utente attraverso un menù testuale. Questa classe utilizza le seguenti componenti:

1. **Scanner**:
   Viene utilizzato per leggere gli input dell'utente dalla console.
   ```java
   Scanner scanner = new Scanner(System.in);
   ```

2. **Oggetto `Service`**:
   Inizializza un'istanza della classe `Service`, che gestisce tutte le operazioni legate ai film e alle prenotazioni.
   ```java
   Service service = new Service();
   ```

3. **Menù Interattivo**:
    - Il programma utilizza un ciclo `while` controllato dalla variabile `continua`, che permette di presentare un menù all'utente fino a quando decide di uscire:
      ```java
      while (continua) { ... }
      ```

    - Attraverso un blocco `switch`, viene gestita l'operazione selezionata dall'utente, usando un input numerico (`1`, `2`, ecc.) per differenziare le scelte.

---

## Funzionalità Principali

### **1. Aggiungere un film con orari**
Permette di aggiungere un film indicando il nome e una serie di orari separati da virgola. I dati vengono passati al metodo:
```java
service.aggiungiFilm(nomeFilm, orari);
```
Questo metodo:
- Aggiunge il film e i suoi orari nella lista gestita dall'oggetto `Cinema`.
- Stampa una conferma con il nome del film e gli orari aggiunti.

---

### **2. Aggiungere una prenotazione**
Permette di registrare una nuova prenotazione chiedendo all'utente i seguenti dettagli:
- Nome del cliente.
- Flag per indicare se il cliente è premium.
- Nome del film selezionato.
- Orario della proiezione.
- Numero di posti desiderato.
- Costo base del biglietto.

Queste informazioni vengono inviate al metodo:
```java
service.aggiungiPrenotazione(nomeCliente, isPremium, filmPrenotazione, orarioPrenotazione, posti, costoBiglietto);
```
- Il metodo crea un nuovo oggetto cliente (`Cliente`) e una prenotazione (`Prenotazione`).
- Cerca di aggiungere la prenotazione all'oggetto `Cinema`. Se non riesce (es. posti insufficienti o orario errato), avverte l'utente con un messaggio di errore.

---

### **3. Stampare gli orari di un film specifico**
Chiede all'utente il nome di un film e invoca:
```java
service.stampaOrariFilm(filmDaCercare);
```
- Questo metodo recupera, tramite l'oggetto `Cinema`, gli orari delle proiezioni per il film selezionato.
- Se sono presenti orari, questi vengono stampati. In caso contrario, avvisa che non ci sono proiezioni disponibili.

---

### **4. Stampare posti prenotati e ricavo totale per un orario**
Chiede all'utente un orario specifico e utilizza il metodo:
```java
service.stampaPostiERicavoTotale(orarioRicerca);
```
Questo metodo:
- Ottiene dall'oggetto `Cinema` il numero di posti prenotati e il ricavo totale per quell'orario.
- Stampa le informazioni in modo leggibile.

---

### **5. Uscire dal programma**
Quando l'utente seleziona l'opzione **5**, il programma termina:
```java
continua = false;
System.out.println("Grazie per aver utilizzato il sistema di prenotazione del Cinema!");
```

---

## Struttura della Classe `Service`

La classe `Service` è un intermediario tra la classe `Main` e la logica del sistema, incapsulata nella classe `Cinema`. Le operazioni principali sono suddivise nei seguenti metodi:

1. **`aggiungiFilm`**:
   Permette di aggiungere un film con una lista di orari alla lista mantenuta all'interno dell'oggetto `Cinema`.

2. **`aggiungiPrenotazione`**:
   Aggiunge una nuova prenotazione creando un oggetto cliente e un oggetto prenotazione, e li registra nell'oggetto `Cinema`.

3. **`stampaOrariFilm`**:
   Recupera la lista degli orari di un film e li stampa. Se non ci sono orari disponibili, viene mostrato un messaggio all'utente.

4. **`stampaPostiERicavoTotale`**:
   Stampa il numero di posti prenotati e il ricavo totale per uno specifico orario.

---

## Esempio di Esecuzione

### **Scenario d'uso**
1. L'utente seleziona **1 (Aggiungi un film)**:
    - Nome film: `Avatar`.
    - Orari: `18:00,21:00`.
      Output:
   ```
   Film aggiunto: Avatar con orari: [18:00, 21:00]
   ```

2. L'utente seleziona **2 (Aggiungi una prenotazione)**:
    - Nome cliente: `Mario`.
    - Cliente premium: `true`.
    - Nome film: `Avatar`.
    - Orario: `18:00`.
    - Posti: `3`.
    - Costo biglietto: `10.0`.
      Output:
   ```
   Prenotazione aggiunta con successo.
   ```

3. L'utente seleziona **3 (Stampa orari di proiezione)**:
    - Nome film: `Avatar`.
      Output:
   ```
   Orari di proiezione per 'Avatar': [18:00, 21:00]
   ```

4. L'utente seleziona **4 (Stampa posti e ricavi)**:
    - Orario: `18:00`.
      Output:
   ```
   Posti prenotati alle 18:00: 3
   Ricavo totale per l'orario 18:00: 30.0
   ```

5. L'utente seleziona **5 (Esci)** per terminare il programma:
   ```
   Grazie per aver utilizzato il sistema di prenotazione del Cinema!
   ```

---

## Conclusione

Questo programma fornisce una struttura chiara e robusta per un sistema di prenotazione di cinema. Le funzionalità sono suddivise logicamente, rendendo il codice modulare ed espandibile. Con opportuni miglioramenti, può essere adattato per un'applicazione più complessa, come la gestione di più sale, prenotazioni differenziate per categorie di biglietti o funzionalità aggiuntive come il calcolo dinamico delle disponibilità. 