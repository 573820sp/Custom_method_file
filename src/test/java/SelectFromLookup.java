package com.CustomFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.constants.SystemDefaults;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

public class SelectFromLookup extends General {
	public SelectFromLookup(CommandControl cc) {
		super(cc);
	}

	@Action(object = ObjectType.BROWSER, desc = "Select Lookup field Item by providing Data to select and Object Id", input = InputType.YES, condition = InputType.YES)

	public void MSCRM_SelectFromLookup() {
		try {
			WebElement lookup = Driver.findElement(By.xpath("//input[contains(@data-id,'" + Condition + "')]"));
			Thread.sleep(1000);
			lookup.clear();
			Thread.sleep(2000);
			lookup.sendKeys(Keys.CONTROL + "a");
			lookup.sendKeys(Keys.DELETE);
			Thread.sleep(1000);
			lookup.sendKeys(Data);
			//lookup.sendKeys(Keys.ENTER);
			Driver.findElement(By.xpath("//button[contains(@aria-label,'Search records for Regarding')]")).click();
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(Driver, 30);

			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//li//span[text()='" + Data + "']")));
			wait.until(ExpectedConditions.elementToBeClickable(By
					.xpath("//li//span[text()='" + Data + "']")));
			WebElement lookupItem = Driver.findElement(By
					.xpath("//li//span[text()='" + Data + "']"));
			
			//JavascriptExecutor js = (JavascriptExecutor) Driver;
			//js.executeScript("arguments[0].click();", lookupItem);
			
			
			lookupItem.click();
			Thread.sleep(1000);
			Report.updateTestLog(Action, "Select " + Data + "from Lookup" + ObjectName, Status.DONE);
		} catch (Exception e) {
			Report.updateTestLog(Action, "Unable to select Lookup value. " + e.getMessage() + ObjectName, Status.FAIL);
		}

	}
}
