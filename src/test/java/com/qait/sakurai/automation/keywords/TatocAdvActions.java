package com.qait.sakurai.automation.keywords;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebDriver;
import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.APIClient;
import com.qait.automation.utils.DatabaseUtility;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.YamlReader;

public class TatocAdvActions extends GetPage {

	public TatocAdvActions(WebDriver driver) {
		super(driver, "TatocAdv");
	}

	public void clickOnAdvCourse() {
		clickOnAnchorTagLink("Advanced Course");
		verifyPageTitleContains("Hover Menu");
	}

	public void moveToMenu2AndGoNext() {
		hover(element("divTag_menu2"));
		element("spanTag_nextBtn").click();
		verifyPageTitleContains("Query Gate");
	}

	public void fetchCredentialsEnterAndProceed() {
		String symbol_text = element("divTag_symbol").getText();
		String url = YamlReader.getData("DB_url");
		String user_name = YamlReader.getData("DB_userName");
		String password = YamlReader.getData("DB_password");
		ArrayList<String> cred = DatabaseUtility.fetchCredentials(url, user_name, password, symbol_text);
		element("inputTag_nameTextFld").sendKeys(cred.get(0));
		element("inputTag_passkeyFld").sendKeys(cred.get(1));
		element("inputTag_submitBtn").click();
		verifyPageTitleContains("Video Player");
	}

	public void skipThePlayerPage() {
		executeJavascript("played=true;");
		clickOnAnchorTagLink("Proceed");
		verifyPageTitleContains("Restful");
	}

	public void getSessionAndPostSignature(){
		String getUrl = YamlReader.getData("get_url");
		String post_url = YamlReader.getData("post_url");
		try {
			APIClient.getSessionAndPostSignature(element("spanTag_sessionObj"), getUrl, post_url);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		clickOnAnchorTagLink("Proceed");
		verifyPageTitleContains("File Handle");
	}

	public void downloadFileOnFileHandPage() {
		clickOnAnchorTagLink("Download File");
		wait.waitForFileToBeFound(YamlReader.getData("filePath"));
	}

	public void readFiledataAndEnterSignature() {
		String filePath = YamlReader.getData("filePath");
		String signature = PropFileHandler.readProperty("Signature", filePath);
		element("inputTag_signatureField").sendKeys(signature);
		element("inputTag_proceedBtn").click();
		System.out.println("##### FILE DELETE RESULT #####\n");
		PropFileHandler.deleteFile(filePath);
		verifyPageTitleContains("End");
	}
	
	public void clickOnAnchorTagLink(String linkName) {
		element("anchorTag_Lnks" , linkName).click();
	}

}
