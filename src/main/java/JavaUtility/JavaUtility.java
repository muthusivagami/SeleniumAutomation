package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random=new Random();
		int randcount = random.nextInt(1000);
		return randcount;	
	}
	
	public String getCurrentDate() {
		Date date=new Date();
		SimpleDateFormat sim= new SimpleDateFormat("MM-dd-YYYY");
		String CurrentDate = sim.format(date);
		return CurrentDate;
	}
	
	public String togetRequired(int days) {
		Date date = new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-YYYY");
		sim.format(date);
		Calendar cal= sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, days);
		String datarequired = sim.format(cal.getTime());
		return datarequired;
		
	}
}
