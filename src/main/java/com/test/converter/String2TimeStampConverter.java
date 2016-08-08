package com.test.converter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class String2TimeStampConverter implements Converter<String,Timestamp>	 {

	public Timestamp convert(String source) {   
		 if(source==null||source.trim().length()<1){
			 
			 return null;
		 }
	     else if (source!=null&&source.trim().length()>10) {
	    	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    	dateTimeFormat.setLenient(false);   
	    	Date date;
			try {
				date = dateTimeFormat.parse(source);
				return new Timestamp(date.getTime());
			} catch (ParseException e) {
			}
	    	
		}else{
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");   
			    dateFormat.setLenient(false);   
			    try {   
			    	Date date =  dateFormat.parse(source);
			    	return new Timestamp(date.getTime());
			    } catch (ParseException e) {   
			    }          
		}
	   
	    return null;   
	}   
	
}
