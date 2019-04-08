package main.commands;

import main.commands.InOutStream;

/**
 * Classe che implemeneta l'interfaccia InOut con lo scopo di fare da ponte fra la console e gli utilizzatori dell'interfaccia
 * @author Matteo
 *
 */
public class SimpleStreamAdapter implements InOutStream{
	
	/* (non-Javadoc)
	 * @see command.InOutStream#read()
	 */
	@Override
	public String read(String str) {
		write(str);
		return System.console().readLine();
	}

	/* (non-Javadoc)
	 * @see command.InOutStream#write(java.lang.String)
	 */
	@Override
	public void write(String str) {
		System.out.print(str);
	}

	/* (non-Javadoc)
	 * @see command.InOutStream#writeln(java.lang.String)
	 */
	@Override
	public void writeln(String str) {
		System.out.println(str);
	}
	
}
