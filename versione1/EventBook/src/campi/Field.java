package campi;

/**La classe Campo ha il compito di fornire una struttura adatta a contenere una descrizione ed un valore
 * 
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 * Il valore che contiene può essere di diversi tipi, per ogni campo questo deve essere specificato
 * @param <T> Il tipo di valore che un campo può contenere
 */
public class Field <T>{
	//Attributi
	/**
	 * Contiene le informazioni generali di un campo
	 */
	private ExpandedHeading heading;
	/**
	 * Contiene il valore del campo
	 */
	private T value;
	/**
	 * La stringa usata per mostrare le principali caratteristiche del campo
	 */
	private final static String TOSTRING_FORMAT ="%sValore: %s%n";
	
	//Costruttore
	/**Costruttore del campo, imposta il suo valore a null 
	 * @param heading La descrizione del campo
	 */
	public Field(ExpandedHeading heading) {
		this.heading = heading;
		this.value = null;
	}
	
	//Metodi
	/**Restituisce il nome del campo
	 * @return Il nome del campo
	 */
	public String getName() {
		return heading.getName();
	}
	/**Visualizza le caratteristiche del campo in forma testuale
	 * @return Le caratteristiche del campo
	 */
	public String showFeatures() {
		return heading.toString();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format(TOSTRING_FORMAT, heading.toString(), value);
	}
}
