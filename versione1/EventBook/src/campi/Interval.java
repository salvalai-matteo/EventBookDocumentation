package campi;

/**Classe con il compito di ospitare due dati numerici interi
 * @author Matteo Salvalai [715827], Lorenzo Maestrini [715780], Jacopo Mora [715149]
 *
 */
public class Interval {

	//ATTRIBUTI
	/**
	 * Il minore fra i due dati
	 */
	private int infExt;
	/**
	 * Il maggiore fra i due dati
	 */
	private int supExt;
	
	//COSTRUTTORE
	/**Costruttore 
	 * @param infExt Il dato numerico più piccolo si vuole assegnare
	 * @param supExt Il dato numerico più grande si vuole assegnare
	 */
	//estremoSuperiore >= estremoInferiore
	public Interval(int infExt, int supExt) {
		this.infExt = infExt;
		this.supExt = supExt;
	}
	//this.estremoSuperiore >= this.estremoInferiore

	//TOSTRING
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return infExt + " - " + supExt;
	}
}
