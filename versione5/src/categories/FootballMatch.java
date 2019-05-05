package categories;

import fields.Field;
import fields.FieldHeading;
import fields.FieldSet;
import fields.FieldSetFactory;

/**Classe con il compito di istanziare eventi legati ad una partita di calcio
 * @author Matteo Salvalai [715827], Lorenzo Maestrini[715780], Jacopo Mora [715149]
 *
 */
public class FootballMatch extends Category{

	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore
	 */
	public FootballMatch() {
		super();
		heading = CategoryHeading.FOOTBALLMATCH;
		//fields = FieldSetFactory.getInstance().getSet(CategoryHeading.FOOTBALLMATCH.getName());
		fields = FieldSetFactory.getInstance().commonSet(); //Da spostare nella classe padre Category ?
		fields.add(new Field<>(FieldHeading.GENERE));
		fields.add(new Field <>(FieldHeading.FASCIA_ETA));
	}
}
