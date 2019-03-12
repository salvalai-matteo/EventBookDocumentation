package categories;

import fields.FieldSet;

/**Classe con il compito di definire il comportamento di una categoria
 * 
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public abstract class Category {
	//Attributi
	/**
	 * Contiene un insieme di campi
	 */
	private FieldSet commonSet;
	
	//Costruttore
	/**
	 * Costruttore
	 */
	public Category() {
		commonSet = FieldSet.buildCommonSet();
	}
	/**Visualizza la struttura di quello che può contenere in forma testuale.
	 * Non visualizza un loro eventuale contenuto
	 * @return La struttura in forma testuale
	 */
	public static String showFeatures(){
		return FieldSet.showFeatures(FieldSet.buildCommonSet());
	}
	
}
