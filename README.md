# EventBookDocumentation
Repostitory in cui caricare tutta la documentazione sulle varie versioni del progetto "EventBook"<br>
Linee guida:<br>
  documentazione: Una cartella per versione, una di riassunto per il progetto complessivo
  una cartella per ogni versione contenete il codice


resource o resources? FATTO

Il design mi piace e l’idea di avere due main diversi costringe a separare view e controller in modo netto

Nella classe CommandsHandler c’è qualcosa di strano: tutti i metodi che aggiungono/tolgono elementi dalla lista dei comandi sanno i comandi di tutti… SRP???

FieldSetFactory non è OCP ma se è l’unico punto mi può piacere.

Proverei a rimuovere tutto quando è statico (i singleton!!!)
