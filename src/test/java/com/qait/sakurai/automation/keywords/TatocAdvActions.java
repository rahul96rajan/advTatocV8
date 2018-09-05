package com.qait.sakurai.automation.keywords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.ClientProtocolException;
import org.apache.tools.ant.input.PropertyFileInputHandler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.APIClient;
import com.qait.automation.utils.DatabaseUtility;
import com.qait.automation.utils.PropFileHandler;

public class TatocAdvActions extends GetPage {

	public TatocAdvActions(WebDriver driver) {
		super(driver, "TatocAdv");
	}

	public void clickOnAdvCourse() {
//		isElementDisplayed("advCrseLnk");
		element("advCrseLnk").click();
		verifyPageTitleContains("Hover Menu");
	}

	public void moveToMenu2AndGoNext() {
		hover(element("menu2"));
		element("nextBtn").click();
		verifyPageTitleContains("Query Gate");
	}

	public void fetchCredentialsEnterAndProceed() {
		String sym = element("symbol").getText();
		ArrayList<String> cred = DatabaseUtility.fetchCredentials("tatoc", "tatocuser", "tatoc01", "10.0.1.86", "3306",
				sym);
		element("nameTextFld").sendKeys(cred.get(0));
		element("pskeyFld").sendKeys(cred.get(1));
		element("submitBtn").click();
		verifyPageTitleContains("Video Player");
	}

	public void skipThePlayerPage() {
		executeJavascript("played=true;");
		element("proceedLnk").click();
		verifyPageTitleContains("Restful");
	}

	public void getSessionAndPostSignature() throws ClientProtocolException, IOException {
		String getUrl = "http://10.0.1.86/tatoc/advanced/rest/service/token/";
		String post_url = "http://10.0.1.86/tatoc/advanced/rest/service/register";
		APIClient.getSessionAndPostSignature(element("sessionObj"), getUrl, post_url);
		element("proceedLink").click();
		verifyPageTitleContains("File Handle");
	}

	public void downloadFileOnFileHandPage() throws InterruptedException {
		element("downloadLnk").click();
		hardWait(3);
	}

	public void readFiledataAndEnterSignature() {
		String filePath = "C:/Users/rahulrajan/Downloads/file_handle_test.dat";
		String signature = PropFileHandler.readProperty("Signature", filePath);
		element("signatureField").sendKeys(signature);
		element("proceedBtn").click();
//		PropFileHandler.deleteFile(filePath);
		verifyPageTitleContains("End");    
	}


	/*
	 * filedir=C:/Users/rahulrajan/Downloads/file_handle_test.dat
	 */

}
