package com.qait.sakurai.automation.tests;

import org.testng.annotations.Test;
import com.qait.automation.TestSessionInitiator;

public class TatocAdv_Test extends TestSessionInitiator {
	
	@Test
	public void Test1_testClickOnAdvCourse() {
		tatocAdv.clickOnAdvCourse();		
	}
	
	@Test
	public void Test2_testMoveToMenu2AndGoNext() {
		tatocAdv.moveToMenu2AndGoNext();
	}
	
	@Test
	public void Test3_testfetchCredentialsEnterAndProceed() {
		tatocAdv.fetchCredentialsEnterAndProceed();
	}
	
	@Test
	public void Test4_testSkipThePlayerPage() {
		tatocAdv.skipThePlayerPage();
	}
	
	@Test
	public void Test5_testGetSessionAndPostSignature() {
		tatocAdv.getSessionAndPostSignature();
	}
	
	@Test
	public void Test6_testDownloadFileAndInputSign(){
		tatocAdv.downloadFileOnFileHandPage();
		tatocAdv.readFiledataAndEnterSignature();		
	}
	
}
