package fields;

import java.time.*;
import java.util.ArrayList;

/**Definisce una struttura dati con il compito di gestire di più campi
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class FieldSet extends ArrayList<Field<?>>{
	private static final long serialVersionUID = 1L;
	private static final String FOOTBALLMATCH = "Partita di Calcio";
	private static final String SEPARATOR = "*******************************%n";

	/**Restituisce un campo il cui nome corrisponde a quello inserito
	 * @param name Il nome del campo che si vuole selezionare
	 * @return Il campo con il nome inserito, null altrimenti
	 */
	public Field<?> getField(String name) {
		Field<?> ris = null;
		ris = this.stream()
				.filter((c)->c.getName().equals(name))
				.findFirst()
				.get();
		return ris;
	}
	
	/**Metodo statico che consente di generare una collezione di campi prestabilita
	 * @return il contenitore contenente i campi prestabiliti
	 */
	public static FieldSet buildCommonSet() {
		FieldSet set = new FieldSet();
		set.add(new Field <String>(FieldHeading.TITOLO));
		set.add(new Field <Integer>(FieldHeading.NUMEROPARTECIPANTI));
		set.add(new Field <LocalDate>(FieldHeading.TERMINEISCRIZIONE));
		set.add(new Field <String>(FieldHeading.LUOGO));
		set.add(new Field <LocalDate>(FieldHeading.DATA));
		set.add(new Field <LocalTime>(FieldHeading.ORA));
		set.add(new Field <Integer>(FieldHeading.DURATA));
		set.add(new Field <Double>(FieldHeading.QUOTAINDIVIDUALE));
		set.add(new Field <String>(FieldHeading.COMPRESONELLAQUOTA));
		set.add(new Field <LocalDate>(FieldHeading.DATACONCLUSIVA));
		set.add(new Field <LocalTime>(FieldHeading.ORACONCLUSIVA));
		set.add(new Field <String>(FieldHeading.NOTE));
		return set;
	}
	
	/**Metodo statico che consente di generare una collezione di campi prestabilita a seconda del parametro in ingresso
	 * @param category Il parametro per scegliere quale contenitore generare
	 * @return Il contenitore contenente i campi prestabiliti
	 */
	public static FieldSet buildSpecificSet(String category) {

		FieldSet contenitore = new FieldSet();
		switch(category) {
			case FOOTBALLMATCH:
					contenitore.add(new Field <String>(FieldHeading.GENERE));
					contenitore.add(new Field <Interval>(FieldHeading.FASCIADIETA));
					break;
			default:
					break;
		}
		return contenitore;
	}
	
	/**Metodo che, data una collezione in ingresso, restituisce la descrizione del suo contenuto in forma testuale
	 * Non visualizza il valore attuale del contenuto
	 * @param set Il contenitore di cui si vuole visualizzare il contenuto
	 * @return La stringa testuale che descrive la struttura del contenuto
	 */
	public static String showFeatures(FieldSet set) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<set.size(); i++) {
			sb.append(set.get(i).showFeatures());
			sb.append(String.format(SEPARATOR));
		}
		return sb.toString();
	}
	
	
}
