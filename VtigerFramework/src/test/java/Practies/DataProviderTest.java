package Practies;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider="dataProvider_test")
	public void bookticket(String src,String dst)
	{
		System.out.println("book tickets from "+src+" to "+dst+"");
		
	}
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr = new Object[5][2];
		objArr[0][0]="Bangalore";
		objArr[0][1]="goa";
		
		objArr[1][0]="Bangalore";
		objArr[1][1]="mysore";
		
		objArr[2][0]="Bangalore";
		objArr[2][1]="mumbai";
		
		objArr[3][0]="Bangalore";
		objArr[3][1]="mangalore";
		
		objArr[4][0]="Bangalore";
		objArr[4][1]="kerala";
		
		return objArr;
		
		
	}

}
