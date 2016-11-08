package utility;

import java.text.*;
import java.util.*;

public class DataUtility {
	
	 //trasformo da util.Date a Calendar
    public static Calendar utilDateToCalendar(Date data){
    	Calendar callendar = Calendar.getInstance();
    	callendar.setTimeInMillis(data.getTime());
    	return callendar;
    }
	
	//trasformo da Calendar a util.Date
    public static Date calendarToUtilDate(Calendar callendar){
  	   	return  callendar.getTime();
    }
    
   
    
  //trasformo da String a util.Date
  	public static Date stringToDate(String data) throws ParseException{
  		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  		Date date = sdf.parse(data);
  		return date;
  	}
    
    //trasformo da util.Date a sql.Date
	public static java.sql.Date utilDateToSqlDate(Date data){
		return new java.sql.Date(data.getTime());	
	}
	
    //trasformo da sql.Date a util.Date
	public static Date sqlDateToUtilDate(java.sql.Date data){
		return new Date(data.getTime());	
	}	
	
	//guardo le differenza tra le date di restitutione/prestito
	public static long getDifferenzaGiorni(Date data1, Date data2){
		long diffMillisecond = data2.getTime()-data1.getTime();
		long diff = diffMillisecond/86400000;
		return diff;
	}
}
