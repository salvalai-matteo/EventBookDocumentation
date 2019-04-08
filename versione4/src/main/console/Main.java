package main.console;

import java.io.IOException;

import main.commands.*;

/**
 * Classe contente il punto di partenza da cui far iniziare il programam
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class Main {

	private static CommandsHandler handler;
	
	/**
	 * Il punto da cui far iniziare il programma
	 * @param args lista di argomenti da passare
	 */
	public static void main(String[] args) {
		SimpleStreamAdapter ssa = new SimpleStreamAdapter();
		
		Runtime.getRuntime().addShutdownHook(new Thread(() -> { //Intercetta chiusura 		
			try {
				handler.close();
				ssa.writeln("Bye Bye");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));
		System.out.println("Welcome to EventBook");
		handler = CommandsHandler.getInstance(ssa);
		do {
			String command = ssa.read("");
			handler.run(command.trim());
		}while(true);
	}	
}
