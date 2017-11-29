import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
	
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
public class Writer {

	String fileName = "\\Stundenplaner\\file.xls";
	
	public Writer(String name,double[] time,ArrayList<String[]> monday,ArrayList<String[]> tuesday,ArrayList<String[]> wednesday, ArrayList<String[]> thursday, ArrayList<String[]> friday) throws RowsExceededException, WriteException, IOException{
		WritableWorkbook workbook= null;
		Workbook wbn = null;
		File check = new File(fileName);
		boolean exists = check.exists();
		/*if the file doesn't exists create a new one*/
		if(!exists){
			workbook = Workbook.createWorkbook(new File(fileName));
		}
		/*if the File exist edit the file*/
		else{try {
			wbn = Workbook.getWorkbook(new File(fileName));
			if(wbn.getNumberOfSheets()<2){
				workbook = Workbook.createWorkbook(new File(fileName),wbn);
			}else{
				workbook = Workbook.createWorkbook(new File(fileName));
			}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
		
		WritableSheet sheet;
		int sel=0;
		if(name=="bhf"){
				sel=1;
		}
		sheet = workbook.createSheet(name,sel);

		Label capTime = new Label(0,0,"Zeit");
		sheet.addCell(capTime);
		Label capMon= new Label(1,0,"Montag");
		sheet.addCell(capMon);
		Label capTue = new Label(3,0,"Dienstag");
		sheet.addCell(capTue);
		Label capWed = new Label(5,0,"Mittwoch");
		sheet.addCell(capWed);
		Label capThu = new Label(7,0,"Donnerstag");
		sheet.addCell(capThu);
		Label capFri = new Label(9,0,"Freitag");
		sheet.addCell(capFri);
		
		
		for(int i=0;i<time.length;i++){
					 int collumn = 1;

					Number number1 = new Number(0,i+1,time[i]);
					sheet.addCell(number1);
					/*Monday Schedule 2 Shifts
					 * TODO Make dynamic
					 * */
					Label mon = new Label(collumn,i+1,monday.get(0)[i]);
					collumn++;
					sheet.addCell(mon);
					mon = new Label(collumn,i+1,monday.get(1)[i]);
					sheet.addCell(mon);
					collumn++;
					/*-----------------------------------*/
					/*Tuesday Schedule 2 Shifts */
					Label tue = new Label(collumn,i+1,tuesday.get(0)[i]);
					collumn++;
					sheet.addCell(tue);
					tue = new Label(collumn,i+1,tuesday.get(1)[i]);
					sheet.addCell(tue);
					collumn++;
					/*------------------------------------*/
					/*Wednesday Schedule 2 Shifts */
					Label wed = new Label(collumn,i+1,wednesday.get(0)[i]);
					collumn++;
					sheet.addCell(wed);
					wed = new Label(collumn,i+1,wednesday.get(1)[i]);
					sheet.addCell(wed);
					collumn++;
					/*-------------------------------------*/
					/*Thursday Schedule 2 Shifts */
					Label thur = new Label(collumn,i+1,thursday.get(0)[i]);
					collumn++;
					sheet.addCell(thur);
					thur = new Label(collumn,i+1,thursday.get(1)[i]);
					sheet.addCell(thur);
					collumn++;
					/*--------------------------------------*/
					Label fri = new Label(collumn,i+1,friday.get(0)[i]);
					collumn++;
					sheet.addCell(fri);
					fri = new Label(collumn,i+1,friday.get(1)[i]);
					sheet.addCell(fri);
					collumn++;
					
					//workbook.write();
					/*
					Label label = new Label(0,0,"test");
					sheet.addCell(label);
					
					Number number = new Number(0,1,12);
					sheet.addCell(number);
					*/
						
			}
				workbook.write();
				workbook.close();

		}
	}
