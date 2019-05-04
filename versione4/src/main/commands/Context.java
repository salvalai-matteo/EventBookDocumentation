package main.commands;

import java.io.Closeable;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import proposals.ProposalHandler;
import users.Database;
import users.User;
import utility.FileHandler;
import utility.Session;

/**
 * Classe con il compito di gestire il contesto generale dell'applicazione
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class Context implements Closeable{
	
	private static final String NOTICEBOARD = "resources/bacheca.ser";
	private static final String DATABASE = "resources/registrazioni.ser";

	private static final long DELAY = 3600000;//60MIN
	
	private Timer refreshTimer;
	private Session session;
	private Database database;
	private ProposalHandler noticeBoard;
	private InOutStream inOut;
	
	/**
	 * Costruttore 
	 * @param inOut lo stream di ingresso/uscita
	 */
	public Context(InOutStream inOut) {
		this.inOut = inOut;
		this.session = null;
		//logica di creazione degli argomenti del contesto
		load();
		
		refreshTimer = new Timer("RefreshNoticeBoard");
		refreshTimer.schedule(new TimerTask() {
			public void run() {
				noticeBoard.refresh();
			}
		}, DELAY, DELAY);
	}

	/**
	 * Carica tutte le informazioni importanti legate al contesto
	 */
	private void load() {
		inOut.writeln("Caricamento database ...");
		database = (Database)new FileHandler().load(DATABASE);
		if(database == null) {
			database = new Database();
			inOut.writeln("Caricato nuovo database");
			}
		inOut.writeln("Caricamento bacheca ...");
		noticeBoard = (ProposalHandler)new FileHandler().load(NOTICEBOARD);
		if(noticeBoard == null) {
			noticeBoard = new ProposalHandler();
			inOut.writeln("Caricata nuova bacheca");
			}
		
		noticeBoard.getAll()
			.stream()
				.forEach((p)->{	p.getSubscribers()
									.forEach((u)-> { 
										u.setPrivateSpace(database.getUser(u.getName()).getPrivateSpace());
										u.setProfile(database.getUser(u.getName()).getProfile());
									});
								User owner = p.getOwner();
								owner.setPrivateSpace(database.getUser(owner.getName()).getPrivateSpace());
								owner.setProfile(database.getUser(owner.getName()).getProfile());
								});
		
		inOut.writeln("Fine caricamento");
		inOut.writeln("Pronto");
		inOut.write("\n" + "> ");
	}
	
	/**
	 * Salva tutte le informazioni importanti del contesto in modo permanente
	 */
	private void save() {
		inOut.write("Salvataggio bacheca... ");
		inOut.writeln((new FileHandler().save(NOTICEBOARD, noticeBoard))? "completato" : "fallito");
		inOut.write("Salvataggio database... ");
		inOut.writeln((new FileHandler().save(DATABASE, database))? "completato" : "fallito");
	}
	/**
	 * Restituisce lo stream su cui fare operazioni di ingresso/uscita
	 * @return Lo stream di ingresso/uscita
	 */
	public InOutStream getIOStream() {
		return inOut;
	}
	/**
	 * Restituisce l'attuale sessione
	 * @return la sessione attuale
	 */
	public Session getSession() {
		return session;
	}
	/**
	 * Inizializza la sessione legandola all'utente di cui si è inserito il nomignolo se questo è registrato nel databse
	 * @param nomignolo Nomignolo dell'utente
	 * @return True - la sezione è stata inizializzata correttamente<br>False - la sessione non è stata inizializzata correttamente
	 */
	public boolean newSession(String nomignolo) {
		if(database.contains(nomignolo)) {
			session = new Session(database.getUser(nomignolo));
			return true;
		}
		return false;
	}
	/**
	 * Resetta la sessione usata dal contesto
	 */
	public void resetSession() {
		this.session = null;
	}
	/**
	 * Restituisce il database di utenti
	 * @return il database di utenti
	 */
	public Database getDatabase() {
		return database;
	}
	/**
	 * Restituisce il gestore delle proposte
	 * @return il gestore delle proposte
	 */
	public ProposalHandler getProposalHandler() {
		return noticeBoard;
	}
	/**
	 * Chiude tutte le risorse usate dal contesto.<br>
	 * Non è responsabilità del contesto la chiusura dello stream di ingressi uscita
	 * @throws IOException eventuali eccezioni dovute alla chiusura non riuscita delle risorse
	 */
	@Override
	public void close() throws IOException {
		save();
		refreshTimer.cancel();
	}
}
