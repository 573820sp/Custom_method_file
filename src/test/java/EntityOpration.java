package com.CustomFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;

public class EntityOpration extends General {
	public EntityOpration(CommandControl cc) {
		super(cc);
	}

	@Action(object = ObjectType.BROWSER, desc = "Open the Entity from Sitemap Sub-area in MSCRM. ", input = InputType.YES, condition = InputType.NO)

	public void MSCRM_OpenSitemapSubArea() {
		try {

			String prefix = "//div/span[text()='";
			String datafix = "']";
			String finalInput = prefix + Data + datafix;
			WebElement element = Driver.findElement(By.xpath(finalInput));

			if (element != null) {
				element.click();
				// Driver.manage().timeouts().wait();

				Thread.sleep(3000);
				Report.updateTestLog(Action, "Click on the Left Panel Entity Element " + finalInput + ObjectName,
						Status.PASS);

			}
		}

		catch (Exception e) {
			Report.updateTestLog(Action, "Not Click on the Left Panel Entity Element " + e.getMessage() + ObjectName,
					Status.FAIL);

		}
	}

	@Action(object = ObjectType.BROWSER, desc = "Open the Entity from Sitemap Sub-area using JavaScript in MSCRM. ", input = InputType.YES, condition = InputType.NO)

	public void MSCRM_OpenSitemapSubAreaByJS() {
		try {

			String prefix = "//div/span[text()='";
			String datafix = "']";
			String finalInput = prefix + Data + datafix;
			WebElement element = Driver.findElement(By.xpath(finalInput));

			if (element != null) {
				JavascriptExecutor js = (JavascriptExecutor) Driver;
				js.executeScript("arguments[0].click();", element);

				Thread.sleep(3000);
				Report.updateTestLog(Action, "Click on the Left Panel Entity Element " + finalInput + ObjectName,
						Status.PASS);

			}
		}

		catch (Exception e) {
			Report.updateTestLog(Action, "Not Click on the Left Panel Entity Element " + e.getMessage() + ObjectName,
					Status.FAIL);

		}
	}

}
