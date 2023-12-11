package com.CustomFunction;

import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException.ExceptionType;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;

public class ContactLookUp extends General {
	public static final String prefix = "//span/span[text()='";
	public static final String datasfix = "']";

	public ContactLookUp(CommandControl cc) {
		super(cc);
		// TODO Auto-generated constructor stub
	}

	@Action(object = ObjectType.BROWSER, desc = "Search and select value from LookUp field ", input = InputType.YES, condition = InputType.NO)

	public void ClickOnContactLookUpElement() {

		String finalInput = prefix + Data + datasfix;
		try {
			WebElement ele = Driver.findElement(By.xpath(finalInput));
			ele.click();
			Report.updateTestLog(Action, "Click on the RandomWenwement " + finalInput + ObjectName, Status.DONE);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Element is not clicked " + e.getMessage() + finalInput + ObjectName,
					Status.FAIL);
		}

	}

}
