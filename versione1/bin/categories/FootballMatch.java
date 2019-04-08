package categories;

import fields.FieldSet;

/**Classe con il compito di istanziare eventi legati ad una partita di calcio
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class FootballMatch extends Category{
	
	private static final CategoryHeading HEADING = CategoryHeading.FOOTBALLMATCH;
	
	/**
	 * Contiene i campi legati esclusivamente alla partita di calcio
	 */
	private FieldSet specificSet;
	
	public FootballMatch() {
		super();
		specificSet = FieldSet.buildSpecificSet(HEADING.getName());
	}
	
	public static String showDescription() {
		return HEADING.toString();
	}
	
	/**Visualizza la struttura dei suoi campi.
	 * Non visualizza il loro eventuale contenuto
	 * @return La struttura dei suoi campi
	 */
	public static String showFields() {
		StringBuilder sb = new StringBuilder();
		//eventuale visualizzazione intestazione
		sb.append(Category.showFeatures());
		sb.append(FieldSet.showFeatures(FieldSet.buildSpecificSet(HEADING.getName())));
		return sb.toString();
	}
}
