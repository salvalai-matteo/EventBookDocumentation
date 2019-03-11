package categorie;

/**Descrive e genera set di oggetti in grado di contenere una descrizione
 * @author Matteo Salvalai [715827], Lorenzo Maestrini [715780], Jacopo Mora [715149]
 *
 */
public enum Heading {	

	PARTITADICALCIO("Partita di Calcio", "Una partita di calcio tra vari generi e età");
	
	/**
	 * Definisce un formato per la visualizzazione sottoforma di stringa del contenuto dell'oggetto
	 */

	private final static String TOSTRING_FORMAT = "Nome: %s%nDescrizione: %s%n";
	
	/**
	 * Contiene un nome
	 */
	private String name;
	/**
	 * Contiene una descrizione
	 */
	private String description;
	
	/**Costruttore
	 * @param name Il nome da contenere
	 * @param description La descrizione da contenere
	 */
	private Heading(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**Restituisce il nome
	 * @return Il nome
	 */
	public String getName() {
		return name;
	}
	
	/**Restituisce la descrizione
	 * @return La descrizione
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return String.format(TOSTRING_FORMAT, name, description);
	}
}
