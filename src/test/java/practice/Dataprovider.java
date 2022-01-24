package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	@Test(dataProvider="dataprivodertestbook")
	public void dataprovidertest(String stc,String dest)
	{
		System.out.println("Testing data provider"+stc+"to"+dest);
	}
	@DataProvider
	public Object[][] dataprivodertestbook() {
		Object[][] objarr=new Object[3][2];
		
		objarr[0][0]="Banglore";
		objarr[0][1]="TamilNadu";
		
		objarr[1][0]="Banglore";
		objarr[1][1]="Andrapradhesh";
		
		objarr[2][0]="Banglore";
		objarr[2][1]="Delhi";
		return objarr;
	}

}
