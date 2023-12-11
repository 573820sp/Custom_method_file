package com.CustomFunction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

public class SelectTodayDate extends General {
	public SelectTodayDate(CommandControl cc) {
		super(cc);
	}	
	

	@Action(object = ObjectType.BROWSER, desc = "Select the  today Date", input = InputType.NO, condition = InputType.NO)

	public void  SelectTodayDateNow() { 
		
	int Day,Month, year;
		
		GregorianCalendar date=new GregorianCalendar();
		Day=date.get(Calendar.DAY_OF_MONTH);
		Month=date.get(Calendar.MONTH);
		year=date.get(Calendar.YEAR);
		
		String todaydate=Month+"/"+Day+"/"+year;
		//System.out.println(todaydate);
		    if(Condition!=null) {
		    	
		    	
		    	String finalInput=todaydate;
		    	String varStr=Condition;
		    	addVar(varStr, finalInput);
		    	
			   
			   
		    	
		    }
		

     }
	}