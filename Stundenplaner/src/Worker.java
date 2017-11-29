
public interface Worker extends Comparable<Worker>{
	public double getHours();
	public String getName();
	public void setWeeklyHours(double weeklyhours);
	public String toString();
	public int compareTo(Worker compareWorker);
	public double getWeeklyHours();
	public String getType();
	public void setWorkdays(int workday);
	public int getWorkdays(int workday);
}
