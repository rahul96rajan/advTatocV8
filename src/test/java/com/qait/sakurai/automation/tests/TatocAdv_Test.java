package com.qait.sakurai.automation.tests;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;

public class TatocAdv_Test extends TestSessionInitiator {
	
	@Test(priority = 0)
	public void testClickOnAdvCourse() {
		tatocAdv.clickOnAdvCourse();		
	}
	
	@Test(priority = 1)
	public void testMoveToMenu2AndGoNext() {
		tatocAdv.moveToMenu2AndGoNext();
	}
	
	@Test(priority = 2)
	public void testfetchCredentialsEnterAndProceed() {
		tatocAdv.fetchCredentialsEnterAndProceed();
		
	}
	
	@Test(priority = 3)
	public void testSkipThePlayerPage() {
		tatocAdv.skipThePlayerPage();
	}
	
	@Test(priority = 4)
	public void testGetSessionAndPostSignature() throws ClientProtocolException, IOException {
		tatocAdv.getSessionAndPostSignature();
	}
	
	@Test(priority = 5)
	public void testDownloadFileAndInputSign() throws InterruptedException{
		tatocAdv.downloadFileOnFileHandPage();
		tatocAdv.readFiledataAndEnterSignature();		
	}
	
}
