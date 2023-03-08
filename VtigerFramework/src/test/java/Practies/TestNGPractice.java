package Practies;

import org.testng.annotations.Test;
//@Test
public class TestNGPractice {
	
	@Test(priority=1)
	//method1
	public void createContact()
	{
		System.out.println("created");
		
	}
	@Test(invocationCount=2)
	//method2
	public void modifycontact()
	{
		System.out.println("modified");
		
	}
	@Test(dependsOnMethods="createContact")
 //method3
	public void delete()
	{
		System.out.println("deleted");
		
	}


}
