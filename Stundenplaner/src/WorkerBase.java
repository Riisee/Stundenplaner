/**
 * Abstract Class to define a Worker
 * @author Peter Tegethof
 *
 */
public abstract class WorkerBase implements Comparable<Worker>,Worker{
	/*Protected to use them in different sub Classes*/
	protected double hours;
	protected String name;
	protected double weeklyHours;
	protected int workdays[];
/**
 * Super Constructor for Worker 	
 * @param name Name of the Worker
 * @param hours How many hours the worker works in a week
 */
	public WorkerBase(String name,double hours){
		this.hours = hours;
		this.name = name;
		this.weeklyHours = 0;
		int[] whd = {0,0,0,0,0};
		this.workdays = whd;
	}
	/**
	 * set weekly Hours
	 * @param weeklyhours
	 */
	public void setWeeklyHours(double weeklyhours) {
		this.weeklyHours = this.weeklyHours + weeklyhours;
	}
	/**
	 * get weekly Hours
	 */
	public double getWeeklyHours() {
		return this.weeklyHours;
	}
	public double getHours() {
		return this.hours;
	}

	public String getName() {
		return this.name;
	}

	public void setWeeklyHours(float weeklyhours) {
		this.weeklyHours=weeklyhours;

	}
	/**
	 *Compare Method to compare the work hours of Apothekers&PTAs  
	 */
	public int compareTo(Worker compareWorker){
		int comparage=(int) compareWorker.getWeeklyHours();
		return (int)weeklyHours - comparage;
	}
	public void setWorkdays(int workday){
		this.workdays[workday] = 1;
		
	}
	public int getWorkdays(int workday){
		return this.workdays[workday];
	}
}
