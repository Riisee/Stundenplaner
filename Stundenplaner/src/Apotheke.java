import java.io.IOException;
import java.util.ArrayList;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
/**
 * This Class implements a pharmacy.
 * @author Peter Tegethof
 *
 */
public class Apotheke {
	private int openingHour;
	private int cloesingHour;
	private double shifts,maxLength;
	private String name;
	private WorkingHours monday,tuesday,wednesday,thursday,friday;
	//private ArrayList<WorkingHours> week;
	/**
	 * This constructs a Apotheke with openingshours and Workplans for each weak day.
	 * @param name name of the pharmancy
	 * @param open pharmacy opening hour
	 * @param close pharmacy cloesing hour
	 * @param d deprecated
	 */
	public Apotheke(String name,int open,int close,double d){
		this.name=name;
		this.openingHour=open;
		this.cloesingHour=close;
		this.shifts = d;
		monday = new WorkingHours(open,close,d);
		tuesday = new WorkingHours(open,close,d);
		wednesday = new WorkingHours(open,close,d);
		thursday = new WorkingHours(open,close,d);
		friday = new WorkingHours(open,close,d);
		maxLength = 15; //max. Tägliche Stunden Anzahl(halbe Stunden)
		/*minLength = 8; // min. tägliche Stunden Anzahl(halbe Stunden)
		week = new ArrayList<WorkingHours>();
		week.add(monday);
		week.add(tuesday);
		week.add(wednesday);
		week.add(thursday);
		week.add(friday);*/
	}
	@Override
	/**
	 * Simple toString Method
	 */
	public String toString() {
		return "Apotheke [openingHour=" + openingHour + ", cloesingHour="
				+ cloesingHour + ", shifts=" + shifts + ", name=" + name + "]";
	}
	/**
	 * This Method prints the work schedule to the consol
	 * @return a work schedule for all weekdays 
	 */
	public String toStringWeek(){
		ArrayList<String[]> MontagShift = monday.Shifts();
		ArrayList<String[]> DiestagShift = tuesday.Shifts();
		ArrayList<String[]> MittwochShift = wednesday.Shifts();
		ArrayList<String[]> DonnerstagShift = thursday.Shifts();
		ArrayList<String[]> FreitagShift = friday.Shifts();
		
		double[] MontagTime = monday.time();
		
		String ret=name+"  Montag "+"  Dienstag "+" Mittwoch "+" Donnerstag "+"Freitag"+"\n";
		
		for(int i=0;i<MontagTime.length;i++){;
			ret = ret + MontagTime[i]+ " " +  MontagShift.get(0)[i]+" " +MontagShift.get(1)[i]+" " + DiestagShift.get(0)[i]+" " + MittwochShift.get(0)[i]+" " + DonnerstagShift.get(0)[i]+" " + FreitagShift.get(0)[i]+"\n";
			//ret = ret + " " + MontagShift.get(1)[i]+" " + DiestagShift.get(1)[i]+" " + MittwochShift.get(1)[i]+" " + DonnerstagShift.get(1)[i]+" " + FreitagShift.get(1)[i]+"\n";
			
		}
		return ret;
		
	}
	/**
	 * Simple getter for Opening Hour
	 * @return opening Hour
	 */
	public float getOpeningHour() {
		return openingHour;
	}
	/**
	 * Simple getter for Closing Hour
	 * @return closing Hour
	 */
	public float getCloesingHour() {
		return cloesingHour;
	}
	/**
	 * deprecated
	 * @return deprecated
	 */
	public double getShifts() {
		return shifts;
	}
	/**
	 * Prints the work shedule to a Excel File
	 */
	public void printToExcel(){
		/*get Work Schedule from the Class WorkingHours
		 * TODO implement more than one shift
		 * */
		ArrayList<String[]> MontagShift = monday.Shifts();
		ArrayList<String[]> DiestagShift = tuesday.Shifts();
		ArrayList<String[]> MittwochShift = wednesday.Shifts();
		ArrayList<String[]> DonnerstagShift = thursday.Shifts();
		ArrayList<String[]> FreitagShift = friday.Shifts();
		/*-----------------------------------------------*/
		double[] MontagTime = monday.time();
		try {
		/*Use the Construtor of Writer to print the work schedule to the Excel File*/
			Writer write = new Writer(this.name,MontagTime,MontagShift,DiestagShift,MittwochShift,DonnerstagShift,FreitagShift);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Simple Name getter
	 * @return name of the pharmacy
	 */
	public String getName() {
		return name;
	}
	/**
	 * Simple getter for the max. working Length
	 * @return max working Length
	 */
	public double getMaxLength(){
		return maxLength;
	}
	/**
	 * Simple Switch Case to get the right Array of the Weekday
	 * @param sel select which weekday
	 * @return returns the array for the selected Weekday
	 */
	public WorkingHours getWeekday(int sel){
		switch(sel){
			case 0: return this.monday;
			case 1: return this.tuesday;
			case 2: return this.wednesday;
			case 3: return this.thursday;
			case 4: return this.friday;
			default: return null;			
		}
	}
}
