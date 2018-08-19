package com.demo.util;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
@PrepareForTest(DemoUtils.class)
public class DemoUtilsTest {

	
	@Test
	public void genMemberCodeTest() {		

		String phone = "";
		Date date = null; 

		String expectation = "201808016789"; // 1
	    PowerMockito.mockStatic(DemoUtils.class); //2
	    PowerMockito.when(DemoUtils.genMemberCode(date,phone)).thenReturn("201808016789"); //3 
	    String actual = DemoUtils.genMemberCode(date,phone); //4
	    Assert.assertEquals(expectation, actual); //5

	}

	
	@Test
	public void genMemberTypeTest() {		

		String expectation = "Platinum"; // 1
	    PowerMockito.mockStatic(DemoUtils.class); //2
	    PowerMockito.when(DemoUtils.genMemberType(25000)).thenReturn("Platinum"); //3
	    String actual = DemoUtils.genMemberType(25000); //4
	    Assert.assertEquals(expectation, actual); //5

	}

}

