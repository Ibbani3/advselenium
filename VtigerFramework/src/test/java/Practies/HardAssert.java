package Practies;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class HardAssert {
	@Test
	public void CreateContact()
	{
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		//HardAssert
	   org.testng.Assert.assertEquals("A", "B");
	   System.out.println("step4");
		System.out.println("step5");
		System.out.println("step6");
	}
	@Test
	public void modifyContact()
	{
		System.out.println("step7");
		System.out.println("step8");
	}
	
	@Test
	public void create()
	{
		String expname="pani";
		String actname="panila";
		org.testng.Assert.assertEquals(expname, actname);
		
	}

}
