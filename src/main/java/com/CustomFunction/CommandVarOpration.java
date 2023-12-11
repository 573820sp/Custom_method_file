package com.CustomFunction;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.commands.JSCommands;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.execution.exception.element.ElementException;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import com.ibm.icu.impl.duration.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

public class CommandVarOpration extends General {
	public static String prefix = "//span/span[text()='";
	public static String datafix = "']/ancestor::button";

	public CommandVarOpration(CommandControl cc) {
		super(cc);
	}

	@Action(object = ObjectType.BROWSER, desc = "Select the option from MSCRM Commandbar. ", input = InputType.YES, condition = InputType.NO)

	public void MSCRM_SelectCommandbarOption() throws InterruptedException {

		String finalInput = prefix + Data + datafix;
		WebElement element = Driver.findElement(By.xpath(finalInput));

		if (Data != null) {
			try {
				element.click();
				// Driver.manage().timeouts().wait();

				Thread.sleep(3000);
				Report.updateTestLog(Action, "Click on the CommanbarElement " + finalInput + ObjectName, Status.PASS);

			} catch (Exception e) {

				String morecommand = "//button[contains(@aria-label,'More commands')]";
				Driver.findElement(By.xpath(morecommand)).click();
				Thread.sleep(4000);
				element.click();
				Report.updateTestLog(Action, "Click on the CommanbarElement " + finalInput + ObjectName, Status.PASS);

			}
		} else {

			throw new ElementException(ElementException.ExceptionType.Element_Not_Found, ObjectName);

		}
	}

	@Action(object = ObjectType.BROWSER, desc = "Select the option from MSCRM Commandbar using JavaScript. ", input = InputType.YES, condition = InputType.NO)

	public void MSCRM_SelectCommandbarOptionByJS() {
		try {
			String finalInput = prefix + Data + datafix;
			WebElement element = Driver.findElement(By.xpath(finalInput));
			if (element != null) {
				JavascriptExecutor js = (JavascriptExecutor) Driver;
				js.executeScript("arguments[0].click();", element);

			}

			else {
				String morecommand = "//button[@aria-label='More commands for Activity']";
				WebElement more = Driver.findElement(By.xpath(morecommand));
				JavascriptExecutor js = (JavascriptExecutor) Driver;
				js.executeScript("arguments[0].click();", more);
				Thread.sleep(4000);

				js.executeScript("arguments[0].click();", element);
			}
			Report.updateTestLog(Action, "Clicked on " + ObjectName, Status.DONE);
		} catch (Exception ex) {
			Logger.getLogger(JSCommands.class.getName()).log(Level.SEVERE, null, ex);
			Report.updateTestLog(Action, "Couldn't click on " + ObjectName + " - Exception " + ex.getMessage(),
					Status.FAIL);
		}
	}

}
