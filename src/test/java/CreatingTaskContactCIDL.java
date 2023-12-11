package com.CustomFunction;

import java.sql.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cognizant.cognizantits.engine.commands.General;
import com.cognizant.cognizantits.engine.core.CommandControl;
import com.cognizant.cognizantits.engine.support.Status;
import com.cognizant.cognizantits.engine.support.methodInf.Action;
import com.cognizant.cognizantits.engine.support.methodInf.InputType;
import com.cognizant.cognizantits.engine.support.methodInf.ObjectType;
import com.ibm.icu.text.SimpleDateFormat;

public class CreatingTaskContactCIDL extends General {
	public CreatingTaskContactCIDL(CommandControl cc) {
		super(cc);
	}

	public static String ActMgmid;
	public static String ActContactname;
	public static String ActEmail;
	public static String ActMobilePhone;
	public static String ActHomePhone;
	public static String ActBusinessPhone;
	public static String ActOtherPhone;
	public static String ActTierStatus;
	public static String ActBirthDay;
	public static String ActStreetAddress;
	public static String ActCityStateZip;
	public static String ActCity;
	public static String ActState;
	public static String ActZip;
	public static String ExpBirthDay;

	@Action(object = ObjectType.BROWSER, desc = "Capture the CIDL Contact details from Contact Lite page. ", input = InputType.NO, condition = InputType.NO)

	public void MSCRM_CaptureCIDLContactDetails() {

		try {
			ActMgmid = Driver.findElement(By.xpath(
					"//div[text()='MGM Rewards #:']/ancestor::div[4]/following-sibling::div[1]//div[contains(@id,'lbl_playerId_txt-component')]"))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page MGM Rewards#: " + ActMgmid, Status.DONE);
			ActContactname = Driver.findElement(By.xpath(
					"//div[text()='Contact Name:']/ancestor::div[4]/following-sibling::div[1]//div[contains(@id,'fullName_txt-component')]"))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page ContactName: " + ActContactname, Status.DONE);

			ActEmail = Driver.findElement(By.xpath("//div[contains(@id,'lbl_email_txt-component')]")).getText();

			Report.updateTestLog(Action, "Store the Contact lite page email: " + ActEmail, Status.DONE);

			ActMobilePhone = Driver.findElement(By.xpath("//div[contains(@id,'mobilePhone_txt-component')]")).getText();

			Report.updateTestLog(Action, "Store the Contact lite page MobilePhone: " + ActMobilePhone, Status.DONE);

			ActHomePhone = Driver.findElement(By.xpath(
					"//div[text()='Home phone:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'homePhone_txt-component')]"))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page HomePhone: " + ActHomePhone, Status.DONE);

			ActBusinessPhone = Driver.findElement(By.xpath("//div[contains(@id,'lbl_businessPhone_txt-component')]"))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page BusinessPhone: " + ActBusinessPhone, Status.DONE);

			ActOtherPhone = Driver.findElement(By.xpath(
					"//div[text()='Other Phone:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'otherphone_txt-component')]\r\n"
							+ ""))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page OtherPhone: " + ActOtherPhone, Status.DONE);

			ActTierStatus = Driver.findElement(By.xpath(
					"//div[text()='Tier Status:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'tierStatus_txt-component')]\r\n"
							+ ""))
					.getText();

			Report.updateTestLog(Action, "Store the Contact lite page TierStatus: " + ActTierStatus, Status.DONE);

			String BirthDate_CIDL = Driver.findElement(By.xpath(
					"//div[text()='Birth Date:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'lbl_playerId_txt_1-component')]\r\n"
							+ ""))
					.getText();
			
			
			if (BirthDate_CIDL.equals("")) {
				ActBirthDay = "---";
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");

				java.util.Date date = formatter.parse(BirthDate_CIDL);
				ActBirthDay = formatter.format(date);
			}
			

			Report.updateTestLog(Action, "Store the Contact lite page BirthDay: " + ActBirthDay, Status.DONE);

			ActStreetAddress = Driver.findElement(By.xpath(
					"//div[text()='Street Address:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'lbl_playerId_txt_2-component')]\r\n"
							+ ""))
					.getText();
			Report.updateTestLog(Action, "Store the Contact lite page StreetAddress: " + ActStreetAddress, Status.DONE);

			ActCityStateZip = Driver.findElement(By.xpath(
					"//div[text()='City, State, Zip:']/ancestor::div[4]/following-sibling::div//div[contains(@id,'lbl_playerId_txt_3-component')]\r\n"
							+ ""))
					.getText();

			if (ActCityStateZip.equals("")) {
				Report.updateTestLog(Action, "Store the Contact lite page CityStateZip: " + ActCityStateZip,
						Status.DONE);
			} else {
				String[] cidlAddress = ActCityStateZip.split(",");

				ActCity = cidlAddress[0].trim();

				Report.updateTestLog(Action, "Store the Contact lite page City: " + ActCity, Status.DONE);

				ActState = cidlAddress[1].trim();

				Report.updateTestLog(Action, "Store the Contact lite page State: " + ActState, Status.DONE);

				ActZip = cidlAddress[2].trim();

				Report.updateTestLog(Action, "Store the Contact lite page Zip: " + ActZip, Status.DONE);
			}

		} catch (Exception e) {
			Report.updateTestLog(Action, "Not finding the WebElement " + e.getMessage() + ObjectName, Status.FAIL);

		}
	}

	@Action(object = ObjectType.BROWSER, desc = "Verify CIDL Data on TASK Contact Info for a contact created from CIDL Contact Lite page. ", input = InputType.NO, condition = InputType.NO)

	public void MSCRM_VerifyCIDLDataOnTask() {
		try {
			// String [] name=ActContactname.split(" ");
			// String ActFirstName=name[0].trim();
			// String ActLastName=name[1].trim();
			String ExpTierStatus = Driver.findElement(By.xpath(
					"//label[text()='Tier Status']/../../../following-sibling::div//select[@aria-label='Tier Status']"))
					.getAttribute("title");
			String ExpFirstName = Driver
					.findElement(By.xpath("//label[text()='First Name']/../../../following-sibling::div//input"))
					.getAttribute("title");

			String ExpLastName = Driver
					.findElement(By.xpath("//label[text()='Last Name']/../../../following-sibling::div//input"))
					.getAttribute("title");

			String dateInString = Driver
					.findElement(By.xpath("//label[text()='Birthday']/../../../following-sibling::div//input"))
					.getAttribute("value");
			if (dateInString.equals("---")) {
				ExpBirthDay = "---";
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");

				java.util.Date date = formatter.parse(dateInString);
				ExpBirthDay = formatter.format(date);
			}
			
			String ExpHomePhone = Driver
					
					.findElement(By.xpath("//label[text()='Home Phone']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpMobilePhone = Driver
					.findElement(By.xpath("//label[text()='Mobile Phone']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpEmail = Driver
					.findElement(By.xpath("//label[text()='Email']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpCity = Driver
					.findElement(By.xpath("//label[text()='City']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpState = Driver
					.findElement(By.xpath("//label[text()='State']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpZip = Driver
					.findElement(By.xpath(
							"//label[text()='Address 1: ZIP/Postal Code']/../../../following-sibling::div//input"))
					.getAttribute("value");
			String ExpMgmid = Driver
					.findElement(By.xpath("//label[text()='MGM Rewards #']/../../../following-sibling::div//input"))
					.getAttribute("value");
			// MGM ID validation

			if (ActMgmid.contains(ExpMgmid)) {
				Report.updateTestLog(Action, "CIDL MGM ID matches with CRM MGM ID : " + ExpMgmid, Status.PASS);
			} else {
				Report.updateTestLog(Action, "CIDL MGM ID : " + ActMgmid + " does not match with CRM MGM ID : " + ExpMgmid,
						Status.FAIL);
			}

			// Contact name validation

			if (ActContactname.contains(ExpFirstName)) {
				Report.updateTestLog(Action, "CIDL FirstName is matching with CRM: " + ExpFirstName, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL First Name : " + ActContactname + " does not match with CRM : " + ExpFirstName,
						Status.FAIL);
			}

			if (ActContactname.contains(ExpLastName)) {
				Report.updateTestLog(Action, "CIDL Last Name is matching with CRM : " + ExpLastName, Status.PASS);
			}

			else {
				Report.updateTestLog(Action,
						"CIDL Last Name : " + ActContactname + " does not match with CRM : " + ExpLastName,
						Status.FAIL);
			}

			// Tier status validation

			if (ActTierStatus.equals("") && ExpTierStatus.equals("---")) {

				Report.updateTestLog(Action, "CIDL TierStatus is matches with CRM " + ExpTierStatus, Status.PASS);
			} else if (ActTierStatus.toLowerCase().contains(ExpTierStatus.toLowerCase())) {
				Report.updateTestLog(Action, "CIDL TierStatus is matches with CRM : " + ExpTierStatus,
						Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL TierStatus : " + ActTierStatus + " does not match with CRM : " + ExpTierStatus,
						Status.FAIL);

			}

			// Birth Day validation
			Thread.sleep(5000);
			if (ActBirthDay.equals("") && ExpBirthDay.equals("---")) {
				Report.updateTestLog(Action, "CIDL Birth Date is matches with CRM. " + ExpBirthDay, Status.PASS);
			} else if (ActBirthDay.contains(ExpBirthDay)) {
				Report.updateTestLog(Action, "CIDL Birth Date is matches with CRM.  : " + ExpBirthDay, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL Birth Date : " + ActBirthDay + " does not match with CRM : " + ExpBirthDay,
						Status.FAIL);
			}

			// Home phone Validation
			if (ActHomePhone.equals("") && ExpHomePhone.equals("---")) {
				Report.updateTestLog(Action, "CIDL HomePhone is matches withCRM. " + ExpHomePhone, Status.PASS);
			} else if (ActHomePhone.equals(ExpHomePhone)) {
				Report.updateTestLog(Action, "CIDL HomePhone is matches withCRM. : " + ExpHomePhone, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL HomePhone : " + ActHomePhone + " does not match with CRM: " + ExpHomePhone,
						Status.FAIL);
			}

			// Mobile Phone validation

			if (ActMobilePhone.equals("") && ExpMobilePhone.equals("---")) {
				Report.updateTestLog(Action,
						ActMobilePhone + " CIDL MobilePhone matches with CRM " + ExpMobilePhone, Status.PASS);
			} else if (ActMobilePhone.equals(ExpMobilePhone)) {
				Report.updateTestLog(Action, "CIDL MobilePhone matches with CRM : " + ExpMobilePhone,
						Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL MobilePhone : " + ActMobilePhone + " does not match with CRM: " + ExpMobilePhone,
						Status.FAIL);
			}

			// Email Validation
			if (ActEmail.equals("") && ExpEmail.equals("---")) {
				Report.updateTestLog(Action, "CIDL Email matches with CRM. ", Status.PASS);
			} else if (ActEmail.equals(ExpEmail)) {
				Report.updateTestLog(Action, "CIDL Email matches with CRM:" + ExpEmail, Status.PASS);
			} else {
				Report.updateTestLog(Action, "CIDL Email : " + ActEmail + " does not match with CRM: " + ExpEmail,
						Status.FAIL);
			}

			// City state pin code validation

			if (ActCityStateZip.equals("") && ExpCity.equals("---") && ExpState.equals("---")) {

				Report.updateTestLog(Action, "CIDL City matches with CRM. " + ExpCity, Status.PASS);
				Report.updateTestLog(Action, "CIDL State matches with CRM.  " + ExpState, Status.PASS);
				Report.updateTestLog(Action, "CIDL Zip matches with CRM. " + ExpZip, Status.PASS);
			}

			else {
				if (ActCity.equals(ExpCity)) {
					Report.updateTestLog(Action, "CIDL City matches with CRM : " + ExpCity, Status.PASS);
				} else {
					Report.updateTestLog(Action, "CIDL City : " + ActCity + " does not match with CRM: " + ExpCity,
							Status.FAIL);
				}

				if (ActState.equals(ExpState)) {
					Report.updateTestLog(Action, "CIDL State matches with CRM: " + ExpState, Status.PASS);
				} else {
					Report.updateTestLog(Action,
							"CIDL State : " + ActState + " does not match with CRM: " + ExpState, Status.FAIL);
				}

				if (ActZip.equals(ExpZip)) {
					Report.updateTestLog(Action, "CIDL Zip matches with CRM : " + ExpZip, Status.PASS);
				} else {
					Report.updateTestLog(Action, "CIDL Zip : " + ActZip + " does not match with CRM: " + ExpZip,
							Status.FAIL);
				}

			}
		} catch (Exception e) {
			Report.updateTestLog(Action, "Unable find the WebElement " + e.getMessage() + ObjectName, Status.FAIL);

		}
	}

	@Action(object = ObjectType.BROWSER, desc = "Verify the CIDL data on CONTACT created from CIDL Contact Lite page. ", input = InputType.NO, condition = InputType.NO)

	public void MSCRM_VerifyCIDLDataOnContact() {
		try {
			// String [] name=ActContactname.split(" ");
			// String ActFirstName=name[0].trim();
			// String ActLastName=name[1].trim();
			String ExpTierStatus = Driver.findElement(By.xpath("//div[text()='Tier Status']/parent::div/div/div[last()]")).getText();
			Report.updateTestLog(Action, "Store the Contact lite page MGM Rewards#: " + ActMgmid, Status.DONE);
			String ExpFirstName = Driver
					.findElement(By.xpath("//label[text()='First Name']/ancestor::div/following-sibling::div/following-sibling::div//input"))
					.getAttribute("title");

			String ExpLastName = Driver
					.findElement(By.xpath("//label[text()='Last Name']/ancestor::div/following-sibling::div//input"))
					.getAttribute("title");

			String dateInString = Driver
					.findElement(By.xpath("//label[text()='Birthday']/ancestor::div/following-sibling::div//input"))
					.getAttribute("value");
			if (dateInString.equals("---")) {
				ExpBirthDay = "---";
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");

				java.util.Date date = formatter.parse(dateInString);
				ExpBirthDay = formatter.format(date);
			}
			
			JavascriptExecutor js = (JavascriptExecutor) Driver;
			
			
			Thread.sleep(7000);
			String ExpHomePhone = Driver
					.findElement(By.xpath("//label[text()='Home Phone']/ancestor::div/following-sibling::div//input[@aria-label='Home Phone']"))
					.getAttribute("value");
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			String ExpMobilePhone = Driver
					.findElement(By.xpath("//label[text()='Mobile Phone']/ancestor::div/following-sibling::div//input[@aria-label='Mobile Phone']"))
					.getAttribute("value");
			String ExpEmail = Driver
					.findElement(By.xpath("//label[text()='Email']/ancestor::div/following-sibling::div//input"))
					.getAttribute("value");
			String ExpCity = Driver
					.findElement(By.xpath("//label[text()='City']/ancestor::div/following-sibling::div//input"))
					.getAttribute("value");
			String ExpState = Driver
					.findElement(By.xpath("//label[text()='State']/ancestor::div/following-sibling::div//input"))
					.getAttribute("value");
			String ExpZip = Driver
					.findElement(By.xpath("//label[text()='Zip Code']/ancestor::div/following-sibling::div//input"))
					.getAttribute("value");
			String ExpMgmid = Driver.findElement(By.xpath("//div[text()='MGM Rewards #']/parent::div/div/div[last()]"))
					.getText();
			
			// MGM ID validation

			if (ActMgmid.contains(ExpMgmid)) {
				Report.updateTestLog(Action, "CIDL MGM ID matches with CRM MGM ID : " + ExpMgmid, Status.PASS);
			} else {
				Report.updateTestLog(Action, "CIDL MGM ID : " + ActMgmid + " does not match with CRM MGM ID : " + ExpMgmid,
						Status.FAIL);
			}

			// Contact name validation

			if (ActContactname.contains(ExpFirstName)) {
				Report.updateTestLog(Action, "CIDL FirstName is matching with CRM: " + ExpFirstName, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL First Name : " + ActContactname + " does not match with CRM : " + ExpFirstName,
						Status.FAIL);
			}

			if (ActContactname.contains(ExpLastName)) {
				Report.updateTestLog(Action, "CIDL Last Name is matching with CRM : " + ExpLastName, Status.PASS);
			}

			else {
				Report.updateTestLog(Action,
						"CIDL Last Name : " + ActContactname + " does not match with CRM : " + ExpLastName,
						Status.FAIL);
			}

			// Tier status validation

			if (ActTierStatus.equals("") && ExpTierStatus.equals("---")) {

				Report.updateTestLog(Action, "CIDL TierStatus is matches with CRM " + ExpTierStatus, Status.PASS);
			} else if ((ActTierStatus.toLowerCase().contains(ExpTierStatus.toLowerCase()))) {
				Report.updateTestLog(Action, "CIDL TierStatus is matches with CRM : " + ExpTierStatus,
						Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL TierStatus : " + ActTierStatus + " does not match with CRM : " + ExpTierStatus,
						Status.FAIL);

			}

			// Birth Day validation
			Thread.sleep(5000);
			if (ActBirthDay.equals("") && ExpBirthDay.equals("---")) {
				Report.updateTestLog(Action, "CIDL Birth Date is matches with CRM. " + ExpBirthDay, Status.PASS);
			} else if (ActBirthDay.contains(ExpBirthDay)) {
				Report.updateTestLog(Action, "CIDL Birth Date is matches with CRM.  : " + ExpBirthDay, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL Birth Date : " + ActBirthDay + " does not match with CRM : " + ExpBirthDay,
						Status.FAIL);
			}

			// Home phone Validation
			if (ActHomePhone.equals("") && ExpHomePhone.equals("---")) {
				Report.updateTestLog(Action, "CIDL HomePhone is matches withCRM. " + ExpHomePhone, Status.PASS);
			} else if (ActHomePhone.equals(ExpHomePhone)) {
				Report.updateTestLog(Action, "CIDL HomePhone is matches withCRM. : " + ExpHomePhone, Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL HomePhone : " + ActHomePhone + " does not match with CRM: " + ExpHomePhone,
						Status.FAIL);
			}

			// Mobile Phone validation

			if (ActMobilePhone.equals("") && ExpMobilePhone.equals("---")) {
				Report.updateTestLog(Action,
						ActMobilePhone + " CIDL MobilePhone matches with CRM " + ExpMobilePhone, Status.PASS);
			} else if (ActMobilePhone.equals(ExpMobilePhone)) {
				Report.updateTestLog(Action, "CIDL MobilePhone matches with CRM : " + ExpMobilePhone,
						Status.PASS);
			} else {
				Report.updateTestLog(Action,
						"CIDL MobilePhone : " + ActMobilePhone + " does not match with CRM: " + ExpMobilePhone,
						Status.FAIL);
			}

			// Email Validation
			if (ActEmail.equals("") && ExpEmail.equals("---")) {
				Report.updateTestLog(Action, "CIDL Email matches with CRM. ", Status.PASS);
			} else if (ActEmail.equals(ExpEmail)) {
				Report.updateTestLog(Action, "CIDL Email matches with CRM:" + ExpEmail, Status.PASS);
			} else {
				Report.updateTestLog(Action, "CIDL Email : " + ActEmail + " does not match with CRM: " + ExpEmail,
						Status.FAIL);
			}

			// City state pin code validation

			if (ActCityStateZip.equals("") && ExpCity.equals("---") && ExpState.equals("---")) {

				Report.updateTestLog(Action, "CIDL City matches with CRM. " + ExpCity, Status.PASS);
				Report.updateTestLog(Action, "CIDL State matches with CRM.  " + ExpState, Status.PASS);
				Report.updateTestLog(Action, "CIDL Zip matches with CRM. " + ExpZip, Status.PASS);
			}

			else {
				if (ActCity.equals(ExpCity)) {
					Report.updateTestLog(Action, "CIDL City matches with CRM : " + ExpCity, Status.PASS);
				} else {
					Report.updateTestLog(Action, "CIDL City : " + ActCity + " does not match with CRM: " + ExpCity,
							Status.FAIL);
				}

				if (ActState.equals(ExpState)) {
					Report.updateTestLog(Action, "CIDL State matches with CRM: " + ExpState, Status.PASS);
				} else {
					Report.updateTestLog(Action,
							"CIDL State : " + ActState + " does not match with CRM: " + ExpState, Status.FAIL);
				}

				if (ActZip.equals(ExpZip)) {
					Report.updateTestLog(Action, "CIDL Zip matches with CRM : " + ExpZip, Status.PASS);
				} else {
					Report.updateTestLog(Action, "CIDL Zip : " + ActZip + " does not match with CRM: " + ExpZip,
							Status.FAIL);
				}

			}
		} catch (Exception e) {
			Report.updateTestLog(Action, "Unable find the WebElement " + e.getMessage() + ObjectName, Status.FAIL);

		}
	}

}
