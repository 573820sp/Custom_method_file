package com.CustomFunction;
import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException.ExceptionType;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RandomVariable extends General {

    public RandomVariable(CommandControl cc) {
		super(cc);
		// TODO Auto-generated constructor stub
	}
public static String RandCreation() {
	  String alphanumericCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	  StringBuffer randomString = new StringBuffer(8);
	    Random random = new Random();
	 
	    for (int i = 0; i < 8; i++) {
	        int randomIndex = random.nextInt(alphanumericCharacters.length());
	        char randomChar = alphanumericCharacters.charAt(randomIndex);
	        randomString.append(randomChar);
	    }
	    return randomString.toString();	
}
	

    @Action(object = ObjectType.BROWSER, desc = "Creating Random Variable ",input = InputType.YES, condition = InputType.YES)
    public void RandomVariableCreation() {
    	if(Condition!=null) {
    	String prefix=Data;
    	String suffix=RandCreation();
    	String finalInput=prefix+suffix;
    	String varStr=Condition;
    	addVar(varStr, finalInput);
    	
    	
    	
           Report.updateTestLog(Action, "Created Random Variable is "+finalInput + ObjectName, Status.DONE);
        } else {
            throw new ElementException(ExceptionType.Element_Not_Enabled, ObjectName);
        }
    }



	

}


