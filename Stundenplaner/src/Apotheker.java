/**
 * This Class represents a Apotheker. This Class is a Child from WorkerBase, it inherits every Attribute and Method from its parent.
 * @author Peter Tegethof
 *
 */
public class Apotheker extends WorkerBase{
	/**
	 * Constructs a Apotheker by calling the superconstructor
	 * @param name Name of the Apotheker
	 * @param hours How many hours the Apotheker Works
	 */
	public Apotheker(String name,double hours){
		super(name,hours);
		
	}
	/**
	 *Return the Type of WorkerBase 
	 *@return Apotheker 
	 */
	public String getType(){
		return "Apotheker";
	}
	/**
	 *Simple ToString Method
	 *@return returns identifying String
	 */
	public String toString() {
		return "Apotheker [hours=" + hours + ", name=" + name+ ", weeklyHours=" + weeklyHours + "]\n";
	}

}
