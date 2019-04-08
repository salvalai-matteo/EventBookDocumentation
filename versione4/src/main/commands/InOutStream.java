package main.commands;

public interface InOutStream{

	/**
	 * Legge una stringa dallo stream in ingresso
	 * @param str ciò che si deve leggere
	 * @return la stringa letta dallo stream in ingresso
	 */
	public String read(String str);
	
	/**
	 * Inserisce una stringa nello stream di uscita
	 * @param str la stringa da inserire nello stream in input
	 */
	public void write(String str);
	
	/**
	 * Inserisce una stringa nello stream di uscita sottoforma di linea
	 * @param str la stringa da inserire nello stream in uscita
	 */
	public void writeln(String str);

}
