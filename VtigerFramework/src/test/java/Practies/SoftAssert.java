package Practies;

import static org.testng.Assert.assertEquals;

public class SoftAssert {

	public void createcontact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(false,true);
		System.out.println("step4");
		System.out.println("step5");
		soft.assertAll();		
	}

	private void assertAll() {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(boolean b, boolean c) {
		// TODO Auto-generated method stub
		
	}

}
