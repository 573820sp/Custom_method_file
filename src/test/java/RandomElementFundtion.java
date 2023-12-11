package com.CustomFunction;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

public class RandomElementFundtion extends General {

	public RandomElementFundtion(CommandControl cc) {
		super(cc);
	}

	@Action(object = ObjectType.BROWSER, desc = "Click on the Random Variable that is matching with the Xpath provided", input = InputType.YES, condition = InputType.YES)

	public void ClickOnRandomElement() {
		if (Condition != null) {
			String str = Condition;
			String parts[] = str.split(";");
			String part1 = parts[0];
			String part2 = parts[1];

			String finalInput = part1 + Data + part2;
			try {
				WebElement ele = Driver.findElement(By.xpath(finalInput));
				ele.click();
				Report.updateTestLog(Action, "Click on the Random Web Element. " + finalInput + ObjectName, Status.DONE);
			} catch (Exception e) {
				Report.updateTestLog(Action, "No Element available for the provided Xpath and not clicked. " + e.getMessage() + finalInput + ObjectName,
						Status.FAIL);
			}

		}
	}

	// verify element
	@Action(object = ObjectType.BROWSER, desc = "Verify the Element is present on the page for the Xpath provided. ", input = InputType.YES, condition = InputType.YES)

	public void VerifyRandomElementIsPresent() {
		try {
			if (Condition != null) {
				String str = Condition;
				String parts[] = str.split(";");
				String part1 = parts[0];
				String part2 = parts[1];

				String finalInput = part1 + Data + part2;

				WebElement ele = Driver.findElement(By.xpath(finalInput));
				if (ele.isDisplayed()) {
					Report.updateTestLog(Action,
							"Element is Present for the provided Xpath. " + finalInput + ObjectName, Status.PASS);
				}
			}
		} catch (Exception e) {
			Report.updateTestLog(Action,
					"No Element available for the provided Xpath. " + e.getMessage() + ObjectName,
					Status.FAIL);
		}
	}

	@Action(object = ObjectType.BROWSER, desc = "Click on the Random Variable that is matching with the Xpath provided using JavaScript. ", input = InputType.YES, condition = InputType.YES)

	public void ClickByJsOnRandomElement() {
		if (Condition != null) {
			String str = Condition;
			String parts[] = str.split(";");
			String part1 = parts[0];
			String part2 = parts[1];

			String finalInput = part1 + Data + part2;
			try {
				WebElement ele = Driver.findElement(By.xpath(finalInput));
				JavascriptExecutor js = (JavascriptExecutor) Driver;
				js.executeScript("arguments[0].click();", ele);
				Report.updateTestLog(Action, "Click on the Random Web Element " + finalInput + ObjectName, Status.DONE);
			} catch (Exception e) {
				Report.updateTestLog(Action, "No Element available for the provided Xpath and not clicked. " + e.getMessage() + finalInput + ObjectName,
						Status.FAIL);
			}

		}
	}

}
