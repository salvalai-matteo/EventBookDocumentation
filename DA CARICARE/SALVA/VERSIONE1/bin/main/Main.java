package main;


import java.util.HashMap;
import java.util.Scanner;

import categories.FootballMatch;

/**
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class Main {
	
	private static final String COMMANDS = "I comandi a tua disposizione:"
														+ "\n\thelp\t\tComunica i comandi a disposizione"
														+ "\n\tcategoria\tMostra la categoria disponibile"
														+ "\n\tdescrizione\t\tMostra le caratteristiche della categoria disponibile"
														+ "\n\texit\t\tEsce dal programma";
	private static final String HELP = "help";
	private static final String DESCRIPTION = "descrizione";
	private static final String CATEGORY = "categoria";
	private static final String EXIT = "exit";
	
	private static final String WELCOME = "Welcome to EventBook\n";
	private static final String WAITING = "> ";
	private static final String EXIT_MSG = "Bye Bye";
	
	private static final String ERROR_UNKNOWN_COMMAND = "Il comando inserito non è stato riconosciuto";

	public static void main(String[] args) {
		//condizione d'uscita
		boolean exit = false;
		//protocollo(modo per riconoscere i comandi)
		HashMap <String,Runnable> protocol = new HashMap<>();
		//inizializzazione protocollo(ci inserisco i comandi)
		//comando help
		protocol.put(HELP,()->{
			System.out.println(COMMANDS);
		});
		//comando categoria ( visualizza la categoria)
		protocol.put(CATEGORY,()->{
			System.out.println(FootballMatch.showDescription());
		});
		//comando caratteristiche ( visualizza le caratteristiche della categoria
		protocol.put(DESCRIPTION,()->{
			System.out.println(FootballMatch.showFields());
		});
		// fine inizializzazione protocollo
		//definizione scanner
		Scanner in = new Scanner(System.in);
		//benvenuto
		System.out.println(WELCOME);
		String command;
		//duty cycle
		do {
			System.out.print(WAITING);
			//aspetto input
			command = in.nextLine();
			// elaborazione comando
			if(command.equals(EXIT))
				//voglio uscire
				exit = true;
			else if(protocol.containsKey(command))
				//esecuzione comando
				protocol.get(command).run();
			else
				//comando non riconosciuto
				System.out.println(ERROR_UNKNOWN_COMMAND);
		}while(!exit);
		//uscita
		System.out.println(EXIT_MSG);	
		in.close();
	}
}
