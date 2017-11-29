import java.util.ArrayList;
import java.util.Collections;
/**
 * This Class plans the Work Schedule
 * @author Peter Tegethof
 *
 */
public class Planer {
	ArrayList<Worker> workers;
	ArrayList<Apotheke> apotheke;
	/*test*/
	public Planer(ArrayList<Worker> workers,ArrayList<Apotheke> apotheke){
			this.workers = workers;
			this.apotheke = apotheke;
			/*Shuffle to get different results every Time*/
			Collections.shuffle(workers);
	}
	/**
	 *Simple ToString Method
	 *@return returns identifying String
	 */
	public String toString(){
		String ret = "";
		for(Worker s: workers){
			ret = ret+ s.toString();
			System.out.print("Testi: "+s.toString());
		}
		for(Apotheke a: apotheke){
			ret=ret+ a.toString();
			
		}
		return ret;
	}
	/**
	 * Uses the Apotheken Class to Print every Pharmancy in the excel File
	 */
	public void toStringExcel(){
		
		for(int i=0;i<apotheke.size();i++){
			apotheke.get(i).printToExcel();
			
		}
	}
	/**
	 * This Method uses the book Method to plan a work Schedule
	 * @return
	 * 
	 */
	public String plan(){
		/*TODO 
		 * Check if Workers get too many Hours
		 * plan & book a 2nd Shift
		 * */
		String ret="";

		ArrayList<Integer> listWeekday = new ArrayList<Integer>();
		/*rnd weekday*/
		Collections.shuffle(listWeekday);
		listWeekday.add(0);
		listWeekday.add(1);
		listWeekday.add(2);
		listWeekday.add(3);
		listWeekday.add(4);	
		/*---------------------------------------*/
		/*rnd Apotheke*/
		ArrayList<Integer> listApo = new ArrayList<Integer>();
		listApo.add(0);
		listApo.add(1);
		Collections.shuffle(listApo);
		/*---------------------------------------*/
		while(listWeekday.size()>0){
			/*determin the weekday to book Workers*/
			while(listApo.size()>0){
				/*plan every Apotheke in the List
				 * TODO implement error message if book return -1
				 * */
				book(listApo.get(0),listWeekday.get(0));
				listApo.remove(0);
			}
			/*refill the Apothekenlist*/
			 listApo = refillApo();
			 /*remove weekday because its already planned*/
			 listWeekday.remove(0);
		}
		//Collections.sort(workers);
		
		return ret;
	}
	/**
	 * This Method books work shifts for a Apotheke and Workday
	 * @param apo the pharmancy currently booking
	 * @param weekday the weekday currently booking
	 */
	public int book(int apo,int weekday){
		/*letsgooof*/
		if(workers.size()<1){return -1;}
		if(apotheke.size()<1){return -1;}
		/*var creation and initialization*/
		double workedHours= 0;
		Apotheke apotheke = new Apotheke("",0,0,0);
		WorkingHours wh = new WorkingHours(0,0,0);
		/*get Worker to reduce weekly Hours*/
		/*get rnd Apotheke and rnd Weekday for booking shifts*/
		apotheke = this.apotheke.get(apo);
		/*get the Work Schedule for the Weekday*/
		wh = apotheke.getWeekday(weekday);
		int check =0;
		/*While there is Space in the Work Schedule continue to book shifts*/
		/*Check if already everyone is working*/
		int i=0;
		
		while(check!=-1){
			switch((int)(apotheke.getShifts())){
			case 1: workedHours = wh.bookHours(wh.checkIfWorkisFull(1),(int)(apotheke.getMaxLength())+check, workers.get(i).getName(),1);
					this.workers.get(i).setWorkdays(weekday);
					this.workers.get(0).setWeeklyHours(workedHours);
					break;	
			/*Check if the worker with the least hours has worked on the day. If everybody on the List worked this Day -> break!*/		
			case 2: if(i==workers.size()){break;}
					i = isAlreadyWorking(workers.get(i).getName(),weekday);
					if(i==workers.size()){break;}
					/*book work shift*/
					workedHours = wh.bookHours(wh.checkIfWorkisFull(1),(int)(apotheke.getMaxLength())+check, workers.get(i).getName(),1);
					/*set the weekly Hours for the worker*/
					this.workers.get(i).setWeeklyHours(workedHours);
					/*set that the worker is working for the weekday*/
					this.workers.get(i).setWorkdays(weekday);
					i = isAlreadyWorking(workers.get(i).getName(),weekday);
					if(i==workers.size()){break;}
					workedHours = wh.bookHours(wh.checkIfWorkisFull(2),(int)(apotheke.getMaxLength())+check, workers.get(i).getName(),2);
					this.workers.get(i).setWeeklyHours(workedHours);
					this.workers.get(i).setWorkdays(weekday);
					break;
			case 3: /*TODO implement a dynamic switch-case to book more than 2 shifts*/
			
					break;
			default: break;		
			}
			//this.workers.get(0).setWeeklyHours(workedHours);
			/*Sort the List of Worker(Apotheker&PTAs) to balance there weeklyHours*/
			Collections.sort(workers);
			check = wh.checkIfWorkisFull(1);
			if(i==workers.size()){check=-1;}
		}	
		/*TODO if none hours are booked return -1*/
		return 1;
	}
	/**
	 * This Class refills the Apotheken List. So every Weekday can be booked for each Apotheke.
	 * @return List to determine a rnd pharmancy
	 */
	private ArrayList<Integer> refillApo(){
		/*TODO add Dynamic List Generation*/
		ArrayList<Integer> listWeek = new ArrayList<Integer>();
		listWeek.add(0);
		listWeek.add(1);
		/*listWeekday.add(2);
		listWeekday.add(3);
		listWeekday.add(4);	*/
		Collections.shuffle(listWeek);
		return listWeek;
	}
	/**
	 * Checks if the worker is already working on the day
	 * @param name name of the worker
	 * @param weekday the weekday to check
	 * @return returns a worker the integer in the workerslist that isnt working
	 */
	public int isAlreadyWorking(String name, int weekday){
		int i=0;
		while(workers.size()>i){
			if(workers.get(i).getWorkdays(weekday)==1){i++;}
			else{break;}
		}
		return i;
	}
}
