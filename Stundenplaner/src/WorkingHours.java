import java.util.ArrayList;

/**
 * This Class books and manages the individual work Schedules for each Day. Each Weekday has one Time Array and one Shift Array.
 * @author Peter Tegethof
 *
 */
public class WorkingHours {
	private double workingHours[];
	private String shift1[];
	private String shift2[];
	private String shift3[];
	/**
	 * Constructs a time Array from the openingHours till the closing Hours and fills all shifts with placeholders
	 * @param openingHours opening Hours of the pharmacy
	 * @param closeingHours closing Hours of the pharmacy
	 */
	public WorkingHours(double openingHours,double closeingHours,double shifts){
		
		int arbeitsstunden= (int) ((closeingHours-openingHours)*2)+1;
		//System.out.print(openingHours+" "+closeingHours +"\n");
		this.workingHours = new double[arbeitsstunden];
		this.shift1= new String[arbeitsstunden];
		this.shift2= new String[arbeitsstunden];
		this.shift3= new String[arbeitsstunden];
		double shift;
		int i;
		i=0;
		shift = openingHours;
		/*Placeholders*/
		while(shift<=closeingHours){
			this.workingHours[i]=shift;
			/*TODO use .3 insteat of .5*/
			shift=shift+0.5;
			if(shifts>=1){this.shift1[i]="x";}
			if(shifts>=2){this.shift2[i]="x";}
			else{this.shift3[i]="x";}
			i++;
		}
	}
	public String toString(){
		String ret="";
		for(int i=0;i<workingHours.length;i++){
			ret=ret+this.workingHours[i]+","+this.shift1[i]+","+shift2[i];
			
		}
	 return ret;
	}
	/**
	 * This Method books the work schedule for the day
	 * @param start when the shift starts
	 * @param end when the shift ends
	 * @param name name of the worker who works
	 * @return return how many hours the worker is booked
	 */
	public double bookHours(int start,int end,String name,int whichShift){
		double workedHours = 0;
		for(int i=start;i<end;i++){
			switch(whichShift){
				case 1: shift1[i] = name;	
						break;
				case 2: shift2[i] = name;
						break;
				default: break;		
			}
				
				if(i>=workingHours.length-1){
					break;
				}
				workedHours = workedHours+0.5;
		}
		return workedHours;
	}
	/**
	 * Checks if a work schedule is full
	 * @return returns -1 when the work schedule is full. If the Work Schedule is not full it return the Value of the next free working space.
	 */
	public int checkIfWorkisFull(int whichShift){
		int i=0;
		/**/
		String shift[]= null;
		switch(whichShift){
		case 1: shift = shift1;
				break;
		case 2: shift = shift2;
				break;
		case 3: shift = shift3;
				break;
		}
		while("x"!=shift[i]){
			i++;
			if(shift.length==i){
				return -1;
			}
		}
		return i;
	}
	/**
	 * This Method gets all working Shifts for the weekday
	 * @return return three shifts
	 */
	public ArrayList<String[]> Shifts(){
		ArrayList<String[]> ret = new ArrayList<String[]>();
		ret.add(shift1);
		ret.add(shift2);
		ret.add(shift3);
		return ret;
	}
	/**
	 * This Method returns the timetable for the weekday
	 * @return return the timetable for the weekday
	 */
	public double[] time(){
		return workingHours;
	}
}
