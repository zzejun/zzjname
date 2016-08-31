package jiudian;

import java.util.Calendar;

public class DaytoWeek {
	
	public  int  dayForWeek(Calendar c) throws  Exception {  
		 int  dayForWeek = 0 ; 
		 if (c.get(Calendar.DAY_OF_WEEK) == 1 ){  
		  dayForWeek = 7 ;  
		 }else {  
		  dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1 ;  
		 }  
		 return  dayForWeek;  
		}
}
