package Com.crm.ContactTest;

import org.testng.annotations.Test;
import Com.crm.GenericLib.Baseclass;
import Com.crm.PomPages.ContactPage;
import Com.crm.PomPages.ContactinfoPage;
import Com.crm.PomPages.CreateContactPage;
import Com.crm.PomPages.CreateOrganizationInfoPage;
import Com.crm.PomPages.CreateOrganizationPage;
import Com.crm.PomPages.Homepage;

import Com.crm.PomPages.OrganisationPage;

public class Contacttest extends Baseclass{

	@Test(groups="smoketest")
	public void createcontacttest() throws Throwable
	
	{
	
		
		
		int ran = jlib.getRandomNumber();
		String Contactname = elib.getDataFromExcel("Sheet1",1,1)+ran;
		
		
		Homepage hp=new Homepage(driver);
		hp.getContactlink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactplusbtn().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.Createcontact(Contactname);
		
		
		
		
		ContactinfoPage cip=new ContactinfoPage(driver);
		wlib.waitForElementToBeClickable(driver, cip.getContactheader());
		String head = cip.getContactheader().getText();
		if(head.contains(Contactname))
		{
			System.out.println("Testcase Passed");
		}
		else
		{
			System.err.println("Testcase Failed");
		}
	}

	
	//===========================================================================//
	
	@Test(groups="regressiontest")
	public void createcontactwithIndustrytest() throws Throwable
	{
		 int ran = jlib.getRandomNumber();
		
		/**
		 * Get Data from Excel file
		 */
		String Orgname = elib.getDataFromExcel("Sheet1", 1,0)+ran;
		String Contactname = elib.getDataFromExcel("Sheet1",1,1);
	
		/**
		 * Navigate to Home Page
		 */
		
		Homepage hp=new Homepage(driver);
		hp.getOrglink().click();
		/**
		 * Navigate to Organisation page by clicking on organisation link
		 */
		OrganisationPage op=new OrganisationPage(driver);
		op.getPlusbtn().click();
		/**
		 * Navigate to Create Organization page for creating new orgnization
		 */
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(Orgname);
		/**
		 * Navigate to create Organisation info page for verification
		 */
		
		CreateOrganizationInfoPage coip=new CreateOrganizationInfoPage(driver);
		wlib.waitForElementToBeClickable(driver,coip.getHeader());
		String header = coip.getHeader().getText();
		if(header.contains(Orgname))
		{
			System.out.println("Organization created sucessfullly==PASS");
		}
		else
		{
			System.err.println("Organization not created sucessfully==FAILED");
		}
		coip.getContactlink().click();
		/**
		 * Navigate to contact page by clicking on plus button
		 */
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreatecontactplusbtn().click();
		/**
		 * Navigate to createcontactpage for creating contact
		 */
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.Createcontact(Contactname,Orgname);
		/**
		 * Contactinfo page for verificaion purpose
		 */
		 
		ContactinfoPage cip=new ContactinfoPage(driver);
		wlib.waitForElementToBeClickable(driver,cip.getContactheader());
		String header1 = cip.getContactheader().getText();
		if(header1.contains(Contactname))
		{
			System.out.println("Contact created sucessfullu==PASS");
		}
		else
		{
			System.out.println("Contact not created==FAILED");
		}
	}
}
