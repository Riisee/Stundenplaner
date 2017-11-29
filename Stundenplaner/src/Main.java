import java.util.ArrayList;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class Main {

	/**
	 * @param args
	 * @throws WriteException 
	 * @throws RowsExceededException 
	 */
	public static void main(String[] args) throws RowsExceededException, WriteException {
		Apotheke post = new Apotheke("post",7,20,2);
		Apotheke bhf = new Apotheke("bhf",7,20,2);
		ArrayList<Apotheke> apos = new ArrayList<Apotheke>();
		apos.add(post);
		apos.add(bhf);
		ArrayList<Worker> ptpus = new ArrayList<Worker>();
		System.out.print(apos.toString());
		System.out.print("\n");
		/*
		Apotheker kristin = new Apotheker("Hortmann",40);
		Pta lisa = new Pta("Perez",54);
		Apotheker melanie = new Apotheker("Seidling",50);
		Pta peter = new Pta("Tegethof",20);
		Pta Kata = new Pta("Berwanger",20);
		Pta Flo = new Pta("Hoff",50);
		ArrayList<Worker> ptpus = new ArrayList<Worker>();
		ptpus.add(kristin);
		ptpus.add(lisa);
		ptpus.add(melanie);
		ptpus.add(peter);
		ptpus.add(Kata);
		ptpus.add(Flo);*/
		
		
		
		
		/*System.out.println(ptpus.toString());
		System.out.print(apos.get(0).toStringWeek());
		System.out.print(apos.get(1).toStringWeek());*/
		//plan.toStringExcel();
		SqlHandler sql = new SqlHandler("Chef","123");
		sql.flushDatabase();
		sql.writeUserInDatabase("Perez", 50,"pta");
		sql.writeUserInDatabase("Tegethof", 30,"pta");
		sql.writeUserInDatabase("Hoff", 50,"pta");
		sql.writeUserInDatabase("Mueller", 50,"pta");
		sql.writeUserInDatabase("Hortmann", 50,"apotheker");
		sql.writeUserInDatabase("Seidling", 50,"apotheker");
		sql.writeUserInDatabase("Berwanger", 50,"apotheker");
		sql.writeUserInDatabase("Moitzfeld", 50,"apotheker");
		ptpus = sql.readWorker();
		Planer plan = new Planer(ptpus,apos);
		plan.plan();
		plan.toStringExcel();
		System.out.println(ptpus.toString());
		sql.close();
		
	}

}
