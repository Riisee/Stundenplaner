/**
 * This Class represents a Apotheker. This Class is a Child from WorkerBase, it inherits every Attribute and Method from its parent.
 * @author Peter Tegethof
 *
 */
public class Pta extends WorkerBase implements Worker {
	/**
	 * Constructs a PTA by calling the super constructor
	 * @param name Name of the PTA
	 * @param hours How many hours the PTA works
	 */
	public Pta(String name, double hours) {
		super(name, hours);
		// TODO Auto-generated constructor stub
	}
	/**
	 *Return the Type of WorkerBase 
	 *@return PTA 
	 */
	public String getType() {
		return "PTA";
	}
	/**
	 *Simple ToString Method
	 *@return returns identifying String
	 */
	public String toString() {
		return "PTA [hours=" + hours + ", name=" + name
				+ ", weeklyHours=" + weeklyHours + "]\n";
	}

}
